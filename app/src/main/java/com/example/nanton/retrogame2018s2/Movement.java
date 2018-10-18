package com.example.nanton.retrogame2018s2;

public class Movement {

    private Pacman pacman;
    private int blockSize;
    private int swipeDir;
    private short[][] currentMap;
    private boolean pelletEaten;

    public Movement(short[][] currentMap, int blockSize){
        this.currentMap = currentMap;
        this.blockSize = blockSize;
        pacman = new Pacman(blockSize);
        swipeDir = -1;
        pelletEaten = false;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public int getSwipeDir() {
        return swipeDir;
    }

    public void movePacman(){
        short curValue;
        int xPosPac = pacman.getxPos();
        int yPosPac = pacman.getyPos();
        int nextDir = pacman.getNextDir();
        if ((xPosPac % blockSize == 0) && (yPosPac % blockSize) == 0){
            curValue = currentMap[yPosPac / blockSize][xPosPac / blockSize];
            if (!((nextDir == 3 && (curValue & 1) != 0) ||
                    (nextDir == 1 && (curValue & 4) != 0) ||
                    (nextDir == 0 && (curValue & 2) != 0) ||
                    (nextDir == 2 && (curValue & 8) != 0))) {
                pacman.setCurrentDir(nextDir);
                swipeDir = nextDir;
            }
            if ((swipeDir == 3 && (curValue & 1) != 0) ||
                    (swipeDir == 1 && (curValue & 4) != 0) ||
                    (swipeDir == 0 && (curValue & 2) != 0) ||
                    (swipeDir == 2 && (curValue & 8) != 0)) {
                swipeDir = -1;
            }
        }
    }

    public void updatePacman(){
        if (swipeDir == 0)
            pacman.setyPos(pacman.getyPos() - blockSize / 15);
        else if (swipeDir == 1)
            pacman.setxPos(pacman.getxPos() + blockSize / 15);
        else if (swipeDir == 2)
            pacman.setyPos(pacman.getyPos() + blockSize / 15);
        else if (swipeDir == 3)
            pacman.setxPos(pacman.getxPos() - blockSize / 15);
    }

}
