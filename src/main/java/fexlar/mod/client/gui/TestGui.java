package fexlar.mod.client.gui;

import fexlar.mod.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonToggle;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class TestGui extends GuiScreen {

    int guiWidth = 100;
    int guiHeight = 100;

    GuiButton test;
    final int TEST = 0;

    GuiTextField textBox;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        drawDefaultBackground();
//        drawString(fontRenderer, "TestLOL", (width / 2) - (fontRenderer.getStringWidth("TestLOL") / 2), (height / 2), 0xFFFFFF);

        textBox.drawTextBox();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui()
    {
        buttonList.clear();
        buttonList.add(test = new GuiButton(TEST, (width / 2) - (200 / 2), (height / 2) - (-100 / 2), 200, 20, "Change"));
        textBox = new GuiTextField(0, fontRenderer, (width / 2) - (200 / 2), (height / 2), 200, 20);
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        switch (button.id)
        {
            case TEST:
                EntityPlayer player = Minecraft.getMinecraft().player;
                System.out.println(textBox.getText());
                break;
        }
        super.actionPerformed(button);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        textBox.mouseClicked(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
        textBox.textboxKeyTyped(typedChar, keyCode);
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }


}
