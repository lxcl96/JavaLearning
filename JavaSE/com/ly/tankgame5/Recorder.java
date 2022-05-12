package com.ly.tankgame5;

import javax.swing.plaf.nimbus.State;
import java.io.*;

/**
 * @Author : Ly
 * @Date : 2022/4/6
 * @Description : ·该类记录我方击毁敌方坦克数
 *                ·当游戏结束，将数据写入到文件myRecoed.txt（IO）
 */
public class Recorder {
    private static int score = 0;
    //IO相关
    private static String filePath = "D:\\JavaWork\\JavaLearning\\src\\com\\ly\\myRecoed.txt";
    private static FileWriter fw = null;//节点流
    private static FileReader fr = null;//节点流
    private static BufferedWriter bw = null;//包装流
    private static BufferedReader br = null;//包装流

    //记录得分
    //对此方法进行升级，记录下存活的敌人坦克坐标和方向
    public static void scoreRecord() {
        try {
            fw = new FileWriter(filePath);
            bw = new BufferedWriter(fw);
            bw.write(score);
            bw.newLine();
            if (MyPanel.enemyTanks.size() != 0) {
                for (int i = 0; i < MyPanel.enemyTanks.size(); i++) {
                    EnemyTank e = MyPanel.enemyTanks.get(i);
                    if (e.isLive) {
                        bw.write(e.getX() + "");//x
                        bw.write(" ");
                        bw.write(e.getY() + "");//y
                        bw.write(" ");
                        bw.write(e.getDirect() + "");//方向
                        bw.write(" ");
                        bw.write("0");//类型
                        bw.newLine();
                    }
                }

                //保存我的坦克
                bw.write(MyPanel.hero.getX() + "");//x
                bw.write(" ");
                bw.write(MyPanel.hero.getY() + "");//y
                bw.write(" ");
                bw.write(MyPanel.hero.getDirect() + "");//方向
                bw.write(" ");
                bw.write("1");//类型
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void readScore() {
        try {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            score = br.read();
            if (score == -1)
                score = 0;
        } catch (FileNotFoundException f) {

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String[] readEnemyTanks() {
        String[] strings = new String[MyPanel.enemyTankSize];
        int count = 0;
        try {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            //如果没数据，返回null
            if (br.readLine() == null)
                return null;
            while ((strings[count] = br.readLine()) != null) {
                if(count < MyPanel.enemyTankSize) {
                    count++;
                }
            }
            return strings;
        } catch (IndexOutOfBoundsException var) {
            return strings;
        } catch (FileNotFoundException f) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Recorder.score = score;
    }

    //score++
    public static void addScore() {
        score++;
    }
}
