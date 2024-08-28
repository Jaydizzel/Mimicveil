package com.jaydizzle.mimicveil.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class MimicModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart body;
	private final ModelPart bottom;
	private final ModelPart top;
	private final ModelPart mouth;
	private final ModelPart teeth;

	public MimicModel(ModelPart root) {
		this.body = root.getChild("body");
		this.bottom = body.getChild("bottom");
		this.top = body.getChild("top");
		this.mouth = body.getChild("mouth");
		this.teeth = body.getChild("mouth").getChild("teeth");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bottom = body.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 0).addBox(-7.5F, -10.0F, -7.5F, 15.0F, 10.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition top = body.addOrReplaceChild("top", CubeListBuilder.create().texOffs(0, 25).addBox(-7.5F, -5.0F, -15.5F, 15.0F, 5.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-1.0F, -2.0F, -16.5F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.65F, 7.85F, -0.7854F, 0.0F, 0.0F));

		PartDefinition mouth = body.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(45, 0).addBox(-7.0F, -10.25F, -7.0F, 14.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(56, 36).addBox(-3.0F, -10.75F, -5.25F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(46, 26).addBox(-4.0F, -10.75F, -4.25F, 8.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = mouth.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 45).addBox(-7.0F, -0.5F, -14.9F, 14.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 8.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition teeth = mouth.addOrReplaceChild("teeth", CubeListBuilder.create().texOffs(42, 35).addBox(-7.0F, -14.25F, -7.0F, 0.0F, 4.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(42, 31).addBox(7.0F, -14.25F, -7.0F, 0.0F, 4.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(56, 57).addBox(-7.0F, -14.25F, -7.0F, 14.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = teeth.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(60, 15).addBox(-7.0F, 0.5F, -14.9F, 14.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(42, 39).addBox(7.0F, 0.5F, -14.9F, 0.0F, 4.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(0, 46).addBox(-7.0F, 0.5F, -14.9F, 0.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 8.0F, -0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	@Override
	public ModelPart root() {
		return body;
	}
}
