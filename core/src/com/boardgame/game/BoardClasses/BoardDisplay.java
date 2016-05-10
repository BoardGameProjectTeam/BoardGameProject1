package com.boardgame.game.BoardClasses;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
	
public class BoardDisplay extends JFrame{
	private JPanel panel1, panel2;
    private JButton button = new JButton("Switch Panels");

	public BoardDisplay() {
		super("Board Test");
//begin
        Font font = new Font("SansSerif", Font.BOLD, 30);
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 2, 5, 5));

        JLabel label = new JLabel("four", JLabel.CENTER);
        label.setBackground(Color.MAGENTA);
        label.setFont(font);
        label.setOpaque(true);
        panel1.add(label);

        label = new JLabel("JLabels", JLabel.CENTER);
        label.setBackground(Color.BLUE);
        label.setFont(font);
        label.setOpaque(true);
        panel1.add(label);

        label = new JLabel("are", JLabel.CENTER);
        panel1.add(label);
        label.setBackground(Color.CYAN);
        label.setFont(font);
        label.setOpaque(true);

        label = new JLabel("shown", JLabel.CENTER);
        panel1.add(label);
        label.setBackground(Color.GREEN);
        label.setFont(font);
        label.setOpaque(true);

        font = new Font("Serif", Font.ITALIC, 30);
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        label = new JLabel("five", JLabel.CENTER);
        label.setBackground(Color.GREEN);
        label.setFont(font);
        label.setOpaque(true);
        panel2.add(label, BorderLayout.NORTH);

        label = new JLabel("JLabels", JLabel.CENTER);
        label.setBackground(Color.YELLOW);
        label.setFont(font);
        label.setOpaque(true);
        panel2.add(label, BorderLayout.WEST);

        label = new JLabel("for", JLabel.CENTER);
        label.setBackground(Color.ORANGE);
        label.setFont(font);
        label.setOpaque(true);
        panel2.add(label, BorderLayout.CENTER);

        label = new JLabel("this", JLabel.CENTER);
        label.setBackground(Color.PINK);
        label.setFont(font);
        label.setOpaque(true);
        panel2.add(label, BorderLayout.EAST);

        label = new JLabel("panel", JLabel.CENTER);
        label.setBackground(Color.RED);
        label.setFont(font);
        label.setOpaque(true);
        panel2.add(label, BorderLayout.SOUTH);

        font = new Font("Monospaced", Font.BOLD + Font.ITALIC, 30);
        button.setFont(font);
        add(button, BorderLayout.NORTH);

        add(panel1, BorderLayout.CENTER);
//end
	}
}
