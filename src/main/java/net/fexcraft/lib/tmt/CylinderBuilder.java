package net.fexcraft.lib.tmt;

import static net.fexcraft.lib.tmt.ModelRendererTurbo.MR_BACK;
import static net.fexcraft.lib.tmt.ModelRendererTurbo.MR_BOTTOM;
import static net.fexcraft.lib.tmt.ModelRendererTurbo.MR_FRONT;
import static net.fexcraft.lib.tmt.ModelRendererTurbo.MR_LEFT;
import static net.fexcraft.lib.tmt.ModelRendererTurbo.MR_RIGHT;
import static net.fexcraft.lib.tmt.ModelRendererTurbo.MR_TOP;

import java.util.ArrayList;

import net.fexcraft.lib.common.Static;
import net.fexcraft.lib.common.math.AxisRotator;
import net.fexcraft.lib.common.math.TexturedPolygon;
import net.fexcraft.lib.common.math.TexturedVertex;
import net.fexcraft.lib.common.math.Vec3f;

/**
 * Cylinder Builder Tool, to prevent the need of XYZ amount of chained methods.
 * @author Ferdinand Calo' (FEX___96)
 */
public class CylinderBuilder implements CustomUVBuilder {
	
	private ModelRendererTurbo root;
	private float x, y, z, radius, radius2, length;
	private float base_scale = 1, top_scale = 1;
	private int segments, seglimit, direction;
	private Vec3f topoff = new Vec3f();
	private boolean[] invisible = new boolean[6];
	private float[][] uv = new float[6][];
	private boolean[] detached = new boolean[6];
	private AxisRotator toprot;
	//
	private boolean radialtexture = false;
	private float seg_width, seg_height;
	
	public CylinderBuilder(ModelRendererTurbo root){
		this.root = root == null ? new ModelRendererTurbo(null) : root;
	}
	
	public CylinderBuilder setPosition(float x, float y, float z){
		this.x = x; this.y = y; this.z = z; return this;
	}
	
	public CylinderBuilder setRadius(float first, float second){
		this.radius = first; this.radius2 = second;
		return this;
	}
	
	public CylinderBuilder setLength(float length){
		this.length = length;
		return this;
	}
	
	public CylinderBuilder setTopOffset(float x, float y, float z){
		topoff = new Vec3f(x, y, z); return this;
	}
	
	public CylinderBuilder setTopOffset(Vec3f vec){
		topoff = vec; return this;
	}
	
	@Deprecated
	public CylinderBuilder setSidesVisible(boolean[] arr){
		return removePolygons(arr);
	}

	@Deprecated
	public CylinderBuilder setSidesVisible(boolean base, boolean top, boolean outer, boolean inner){
		return removePolygons(base, top, outer, inner);
	}
	
	public CylinderBuilder removePolygon(int index){
		if(index < 0 || index > 5) return this;
		invisible[index] = true;
		return this;
	}
	
	public CylinderBuilder removePolygons(int... poly_indices){
		for(int index : poly_indices){
			if(index < 0 || index > 5) continue;
			invisible[index] = true;
		}
		return this;
	}

	public CylinderBuilder removePolygons(boolean... sides){
		for(int index = 0; index < 6; index++){
			if(sides.length >= (index + 1) && sides[index]) invisible[index] = true;
		}
		return this;
	}
	
	public CylinderBuilder setPolygonUV(int poly_index, float[] uv){
		if(poly_index < 0 || poly_index > 5) return this;
		this.uv[poly_index] = uv;
		return this;
	}
	
	public CylinderBuilder setPolygonUVs(int[] poly_indices, float[][] uvs){
		for(int i = 0; i < poly_indices.length; i++){
			if(poly_indices[i] < 0 || poly_indices[i] > 5) continue;
			setPolygonUV(poly_indices[i], uvs[i]);
		}
		return this;
	}
	
	public CylinderBuilder setPolygonUVs(float[][] uvs){
		for(int index = 0; index < 6; index++){
			if(index >= uvs.length) break;
			setPolygonUV(index, uvs[index]);
		}
		return this;
	}
	
	public CylinderBuilder setDetachedUV(int... indices){
		for(int index : indices){
			if(index < 0 || index > 5) continue;
			detached[index] = true;
		}
		return this;
	}
	
	public CylinderBuilder setDetachedUV(boolean... bools){
		for(int index = 0; index < 6; index++){
			if(index >= bools.length) break;
			setDetachedUV(index);
		}
		return this;
	}

	private boolean detached(int i){
		return invisible[i] || detached[i];
	}

	/** Currently no support for hollow-less cylinders to be segmented. */
	public CylinderBuilder setSegments(int amount, int limit){
		this.segments = amount;
		this.seglimit = limit;
		return this;
	}
	
	public CylinderBuilder setScale(float base, float top){
		this.base_scale = base;
		this.top_scale = top;
		return this;
	}

	/** Currently no support for hollow-less cylinders to be radial-textured. */
	public CylinderBuilder setRadialTexture(float seg_width, float seg_height){
		if(seg_width <= 0 || seg_height <= 0) return this;
		radialtexture = true;
		this.seg_width = seg_width;
		this.seg_height = seg_height;
		return this;
	}
	
	public CylinderBuilder setDirection(int dir){
		this.direction = dir; return this;
	}
	
	public CylinderBuilder setTopRotation(float x, float y, float z){
		(toprot = AxisRotator.newDefInstance()).setAngles(x, y, z); return this;
	}

	public CylinderBuilder setTopRotation(Vec3f vec){
		return setTopRotation(vec.x, vec.y, vec.z);
	}
	
	public ModelRendererTurbo build(){
		if(segments < 3) segments = 3;
		if(seglimit <= 0) seglimit = segments;
		boolean segl = seglimit < segments;
		if(radius2 == 0f && toprot == null && !segl){
			return root.addCylinder(x, y, z, radius, length, segments, base_scale, top_scale, direction, (int)Math.floor(radius * 2F), (int)Math.floor(radius * 2F), (int)Math.floor(length), topoff);
		}
		float diameter = (int)Math.floor(radius * 2F);
		float texheight = (int)Math.floor(length);
		if(radius < 1){
			int rad = radius < 0.5 ? 1 : 2;
			if(diameter < rad) diameter = rad;
		}
		if(length < 1) texheight = 1;
		else if(length % 1 != 0){
			texheight = (int)length + (length % 1 > 0.5f ? 1 : 0);
		}
		//
		boolean dirTop = (direction == MR_TOP || direction == MR_BOTTOM);
		boolean dirSide = (direction == MR_RIGHT || direction == MR_LEFT);
		boolean dirFront = (direction == MR_FRONT || direction == MR_BACK);
		boolean dirMirror = (direction == MR_LEFT || direction == MR_BOTTOM || direction == MR_BACK);
		if(base_scale == 0) base_scale = 1f;
		if(top_scale == 0){
			//top_scale = 1f;
			invisible[1] = true;
		}
		ArrayList<TexturedPolygon> polis = new ArrayList<>();
		//Vertex
		float xLength = (dirSide ? length : 0), yLength = (dirTop ? length : 0), zLength = (dirFront ? length : 0);
		float xStart = (dirMirror ? x + xLength : x);
		float yStart = (dirMirror ? y + yLength : y);
		float zStart = (dirMirror ? z + zLength : z);
		float xEnd = (!dirMirror ? x + xLength : x) + (topoff == null ? 0 : topoff.x);
		float yEnd = (!dirMirror ? y + yLength : y) + (topoff == null ? 0 : topoff.y);
		float zEnd = (!dirMirror ? z + zLength : z) + (topoff == null ? 0 : topoff.z);
		float xCur = xStart, yCur = yStart, zCur = zStart, sCur = base_scale;
		//Texture
		float[][] uvs = new float[6][];
		float uScale = 1.0F / root.textureWidth, vScale = 1.0F / root.textureHeight;
		float uCircle = diameter * uScale;
		float vCircle = diameter * vScale;
		float uCircle2 = ((int)Math.floor(radius2 * 2F)) * uScale;
		float vCircle2 = ((int)Math.floor(radius2 * 2F)) * vScale;
		float vHeight = texheight * vScale;
		float uSeg = radius - radius2;
		if(uSeg < 1) uSeg = 1;
		else if(uSeg % 1 != 0){
			uSeg = (int)uSeg + (uSeg % 1 > 0.5f ? 1 : 0);
		}
		uSeg *= uScale;
		{
			float x = root.texoffx * uScale, y = root.texoffy * vScale;
			uvs[0] = new float[]{ x, y };
			uvs[1] = new float[]{ x + (detached(0) || radialtexture ? 0 : uCircle), y + (radialtexture && !detached(0) ? seg_height : 0) };
			float cirhi = detached(0) && detached(1) ? 0 : radialtexture ? (seg_height * (detached(0) || detached(1) ? 1 : 2)) * vScale : vCircle;
			float cirwi = detached(2) && detached(3) ? 0 : uCircle + uCircle;
			uvs[2] = new float[]{ x, y + cirhi };
			uvs[3] = new float[]{ x, y + cirhi + (detached(2) ? 0 : vHeight) };
			uvs[4] = new float[]{ x + cirwi, y + cirhi, };
			uvs[5] = new float[]{ x + cirwi + (detached(2) || detached(3) ? uSeg : 0), y + cirhi + (detached(2) || detached(3) ? 0 : vHeight) };
			for(int i = 0; i < uv.length; i++){
				if(invisible[i]) continue;
				if(uv[i] == null || uv[i].length != 2) continue;
				uvs[i][0] = uv[i][0] * uScale;
				uvs[i][1] = uv[i][1] * vScale;
				if(!detached[i]){
					uvs[i][0] += x;
					uvs[i][1] += y;
				}
			}
		}
		float uWidth = (uCircle * 2F) / segments;
		float segpi = Static.PI / segments;
		//Temporary Arrays
		ArrayList<TexturedVertex> verts0 = new ArrayList<>();
		ArrayList<TexturedVertex> verts1 = new ArrayList<>();
		ArrayList<TexturedVertex> verts2 = new ArrayList<>();
		ArrayList<TexturedVertex> verts3 = new ArrayList<>();
		for(int repeat = 0; repeat < 2; repeat++){//top/base faces
			for(int index = 0; index < segments; index++){
				float xSize = (float)((root.mirror ^ dirMirror ? -1 : 1) * Math.sin((segpi) * index * 2F + Static.PI) * radius * sCur);
				float zSize = (float)(-Math.cos((segpi) * index * 2F + Static.PI) * radius * sCur);
				float xPlace = xCur + (!dirSide ? xSize : 0);
				float yPlace = yCur + (!dirTop ? zSize : 0);
				float zPlace = zCur + (dirSide ? xSize : (dirTop ? zSize : 0));
				verts0.add(new TexturedVertex(xPlace, yPlace, zPlace, 0, 0));
				if(index == segments - 1){
					TexturedVertex copy = new TexturedVertex(verts0.get(0)); verts0.add(copy);
				}
				//
				float xSize2 = (float)((root.mirror ^ dirMirror ? -1 : 1) * Math.sin((segpi) * index * 2F + Static.PI) * radius2 * sCur);
				float zSize2 = (float)(-Math.cos((segpi) * index * 2F + Static.PI) * radius2 * sCur);
				xPlace = xCur + (!dirSide ? xSize2 : 0);
				yPlace = yCur + (!dirTop ? zSize2 : 0);
				zPlace = zCur + (dirSide ? xSize2 : (dirTop ? zSize2 : 0));
				verts1.add(new TexturedVertex(xPlace, yPlace, zPlace, 0, 0));
				if(index == segments - 1){
					TexturedVertex copy = new TexturedVertex(verts1.get(0)); verts1.add(copy);
				}
			}
			if(repeat == 0){
				verts2.addAll(verts0);
				verts2.addAll(verts1);
			}
			else{
				verts3.addAll(verts0);
				verts3.addAll(verts1);
			}
			double xSize, ySize;
			boolean bool = repeat == 0 ? dirFront ? false : true : dirFront ? true : false;
			if(!invisible[repeat]){
				for(int i = 0; i < verts0.size(); i++){
					if(i >= (verts0.size() - 1) || i >= seglimit){
						if(repeat != 0 && toprot != null){
							verts0.get(i).vector = toprot.getRelativeVector(verts0.get(i).vector);
							verts1.get(i).vector = toprot.getRelativeVector(verts1.get(i).vector);
						}
						break;
					}
					TexturedVertex[] arr = new TexturedVertex[4];
					if(!radialtexture){
						xSize = Math.sin((segpi) * i * 2F + (!dirTop ? 0 : Static.PI)) * (0.5F * uCircle);
						ySize = Math.cos((segpi) * i * 2F + (!dirTop ? 0 : Static.PI)) * (0.5F * vCircle);
						arr[0] = verts0.get(i).setTexturePosition(uvs[repeat][0] + .5f * uCircle + xSize, uvs[repeat][1] + 0.5F * vCircle + ySize);
						//
						xSize = Math.sin((segpi) * i * 2F + (!dirTop ? 0 : Static.PI)) * (0.5F * uCircle2);
						ySize = Math.cos((segpi) * i * 2F + (!dirTop ? 0 : Static.PI)) * (0.5F * vCircle2);
						arr[1] = verts1.get(i).setTexturePosition(uvs[repeat][0] + .5f * uCircle + xSize, uvs[repeat][1] + 0.5F * vCircle + ySize);
						//
						xSize = Math.sin((segpi) * (i + 1) * 2F + (!dirTop ? 0 : Static.PI)) * (0.5F * uCircle2);
						ySize = Math.cos((segpi) * (i + 1) * 2F + (!dirTop ? 0 : Static.PI)) * (0.5F * vCircle2);
						arr[2] = verts1.get(i + 1).setTexturePosition(uvs[repeat][0] + .5f * uCircle + xSize, uvs[repeat][1] + 0.5F * vCircle + ySize);
						//
						xSize = Math.sin((segpi) * (i + 1) * 2F + (!dirTop ? 0 : Static.PI)) * (0.5F * uCircle);
						ySize = Math.cos((segpi) * (i + 1) * 2F + (!dirTop ? 0 : Static.PI)) * (0.5F * vCircle);
						arr[3] = verts0.get(i + 1).setTexturePosition(uvs[repeat][0] + .5f * uCircle + xSize, uvs[repeat][1] + 0.5F * vCircle + ySize);
					}
					else{
						float diff = uSeg / 4;
						arr[0] = verts0.get(i).setTexturePosition(uvs[repeat][0] + (i * seg_width) * uScale, uvs[repeat][1]);
						arr[1] = verts1.get(i).setTexturePosition(uvs[repeat][0] + (i * seg_width) * uScale + diff, uvs[repeat][1] + (seg_height * vScale));
						arr[2] = verts1.get(i + 1).setTexturePosition(uvs[repeat][0] + ((i + 1) * seg_width) * uScale - diff, uvs[repeat][1] + (seg_height * vScale));
						arr[3] = verts0.get(i + 1).setTexturePosition(uvs[repeat][0] + ((i + 1) * seg_width) * uScale, uvs[repeat][1]);
					}
					if(repeat != 0 && toprot != null){
						arr[0].vector = verts0.get(i).vector = toprot.getRelativeVector(arr[0].vector);
						arr[1].vector = verts1.get(i).vector = toprot.getRelativeVector(arr[1].vector);
						arr[2].vector = /*verts1.get(i + 1).vector =*/ toprot.getRelativeVector(arr[2].vector);
						arr[3].vector = /*verts0.get(i + 1).vector =*/ toprot.getRelativeVector(arr[3].vector);
					}
					polis.add(new TexturedPolygon(arr));
					if(bool) polis.get(polis.size() - 1).flipFace();
				}
			}
			verts0.clear(); verts1.clear(); xCur = xEnd; yCur = yEnd; zCur = zEnd; sCur = top_scale;
		}
		int halfv2 = verts2.size() / 2;
		for(int i = 0; i < halfv2; i++){
			if(i >= seglimit && segl){
				if(!invisible[4]){
					TexturedVertex[] arr = new TexturedVertex[4];
					arr[0] = verts2.get(0).setTexturePosition(uvs[4][0], uvs[4][1]);
					arr[1] = verts3.get(0).setTexturePosition(uvs[4][0], uvs[4][1] + vHeight);
					arr[2] = verts3.get(halfv2).setTexturePosition(uvs[4][0] + uSeg, uvs[4][1] + vHeight);
					arr[3] = verts2.get(halfv2).setTexturePosition(uvs[4][0] + uSeg, uvs[4][1]);
					polis.add(new TexturedPolygon(arr));
					if(!dirFront) polis.get(polis.size() - 1).flipFace();
				}
				if(!invisible[5]){
					TexturedVertex[] arr = new TexturedVertex[4];
					arr[0] = verts2.get(seglimit).setTexturePosition(uvs[5][0], uvs[5][1]);
					arr[1] = verts3.get(seglimit).setTexturePosition(uvs[5][0], uvs[5][1] + vHeight);
					arr[2] = verts3.get(seglimit + halfv2).setTexturePosition(uvs[5][0] + uSeg, uvs[5][1] + vHeight);
					arr[3] = verts2.get(seglimit + halfv2).setTexturePosition(uvs[5][0] + uSeg, uvs[5][1]);
					polis.add(new TexturedPolygon(arr));
					if(dirFront) polis.get(polis.size() - 1).flipFace();
				}
				break;
			}
			if(i >= (halfv2 - 1)) break;
			TexturedVertex[] arr = new TexturedVertex[4];
			if(!invisible[2]){
				arr[0] = verts2.get(i + 0).setTexturePosition(uvs[2][0] + uWidth * (i + 0), uvs[2][1]);
				arr[1] = verts3.get(i + 0).setTexturePosition(uvs[2][0] + uWidth * (i + 0), uvs[2][1] + vHeight);
				arr[2] = verts3.get(i + 1).setTexturePosition(uvs[2][0] + uWidth * (i + 1), uvs[2][1] + vHeight);
				arr[3] = verts2.get(i + 1).setTexturePosition(uvs[2][0] + uWidth * (i + 1), uvs[2][1]);
				polis.add(new TexturedPolygon(arr));
				if(dirFront) polis.get(polis.size() - 1).flipFace();
			}
			if(!invisible[3]){
				arr = new TexturedVertex[4];
				arr[0] = verts2.get(i + halfv2 + 0).setTexturePosition(uvs[3][0] + uWidth * (i + 0), uvs[3][1]);
				arr[1] = verts3.get(i + halfv2 + 0).setTexturePosition(uvs[3][0] + uWidth * (i + 0), uvs[3][1] + vHeight);
				arr[2] = verts3.get(i + halfv2 + 1).setTexturePosition(uvs[3][0] + uWidth * (i + 1), uvs[3][1] + vHeight);
				arr[3] = verts2.get(i + halfv2 + 1).setTexturePosition(uvs[3][0] + uWidth * (i + 1), uvs[3][1]);
				polis.add(new TexturedPolygon(arr));
				if(!dirFront) polis.get(polis.size() - 1).flipFace();
			}
		}
		return root.copyTo(polis);
	}

	public ModelRendererTurbo getRoot(){
		return root;
	}
	
}
