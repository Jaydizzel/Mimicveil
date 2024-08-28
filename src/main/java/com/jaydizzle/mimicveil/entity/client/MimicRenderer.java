package com.jaydizzle.mimicveil.entity.client;

import com.jaydizzle.mimicveil.MimicVeil;
import com.jaydizzle.mimicveil.entity.MimicEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MimicRenderer extends MobRenderer<MimicEntity, MimicModel<MimicEntity>> {
    public MimicRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MimicModel<>(pContext.bakeLayer(JDModelLayers.MIMIC_LAYER)), 0.75f);
    }

    @Override
    public ResourceLocation getTextureLocation(MimicEntity pEntity) {
        return new ResourceLocation(MimicVeil.MOD_ID, "textures/entity/mimic.png");
    }
    @Override
    public void render(MimicEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.3f, 0.3f, 0.3f);
        } else {
            pMatrixStack.scale(1f, 1f, 1f);
        }


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}