package TicTacToe.rendering;

import TicTacToe.rendering.ConsoleRenderer;

import javax.swing.*;

public class RendererFactory {

    public static Renderer tempRenderer ()
    {
        return  new ConsoleRenderer();
    }

}
