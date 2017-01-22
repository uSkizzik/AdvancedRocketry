package zmaster587.advancedRocketry.inventory.modules;

import java.util.LinkedList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import zmaster587.advancedRocketry.client.render.planet.RenderPlanetarySky;
import zmaster587.advancedRocketry.dimension.DimensionProperties;
import zmaster587.libVulpes.inventory.modules.ModuleBase;

public class ModulePanetImage extends ModuleBase {

	DimensionProperties properties;
	float width;

	public ModulePanetImage(int locX, int locY, float size, DimensionProperties icon) {
		super(locX, locY);
		width = size;
	}


	@Override
	public void renderBackground(GuiContainer gui, int x, int y, int mouseX,
			int mouseY, FontRenderer font) {
		super.renderBackground(gui, x, y, mouseX, mouseY, font);

		Tessellator tessellator = Tessellator.getInstance();
		VertexBuffer vertexbuffer = tessellator.getBuffer();
		GL11.glPushMatrix();
		GL11.glRotated(90, -1, 0, 0);
		//GL11.glTranslatef(xPosition, 100 + this.zLevel, yPosition);
		float newWidth = width/2f;

		RenderPlanetarySky.renderPlanetPubHelper(vertexbuffer, properties.getPlanetIcon(), (int)(x + this.offsetX + newWidth), (int)(y + this.offsetY + newWidth), (double)-0.1, newWidth, 1f, properties.getSolarTheta(), properties.hasAtmosphere(), properties.skyColor, properties.ringColor, properties.isGasGiant(), properties.hasRings());
		GL11.glPopMatrix();
	}
	
	public void setDimProperties(DimensionProperties location) {
		properties = location;
	}
}
