package de.rafael.processing;

import processing.core.PApplet;

public class ProcessingMain extends PApplet {

    public static void main(String[] args) {
        PApplet.main(ProcessingMain.class);
    }

    @Override
    public void settings() {
        size(760, 760);
    }

    @Override
    public void setup() {

        //int step = 10;

        /*
        for(int i = 0; i <= width; i += step) {
            stroke(255, 255, 0);
            line(i, 0, width, i);
            stroke(255, 0, 0);
            line(i, 0, 0, height - i);
            stroke(0, 255, 255);
            line(0, height - i, width - i, height);
            stroke(0, 255, 0);
            line(width, height - i, i, height);
        }
         */

        /*
        int h_width = width / 2;
        int h_height = height / 2;

        for(int i = 0; i <= h_width; i += step) {
            stroke(255, 0, 0);
            line(i, h_height, h_width, h_height - i);
            stroke(0, 255, 0);
            line(i, h_height, h_width, h_height + i);
            stroke(0, 0, 255);
            line(h_width + i, h_height, h_width, i);
            stroke(255, 255, 0);
            line(h_width + i, h_height, h_width, height - i);
        }
         */
    }

    @Override
    public void draw() {

    }

}
