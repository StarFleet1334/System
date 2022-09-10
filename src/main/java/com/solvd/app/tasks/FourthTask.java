package com.solvd.app.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class FourthTask {
    private int value;
    public String name;
    private static final Logger logger = LogManager.getLogger(FourthTask.class);

    private FourthTask() {}
    public FourthTask(int value) {
        this.value = value;
        this.name = "Ilia";
    }

    public void draw() {}

    private int count() {return value;}

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<? extends FourthTask> exec = FourthTask.class;
        // With This We Get as private as well as public and protected fields
        Field[] firstF = exec.getDeclaredFields();
        // To access Private Field We need to use setAccessible(true) method
        FourthTask fourthTask = new FourthTask();
        Field field = exec.getDeclaredField("value");
        field.setAccessible(true);
        field.set(fourthTask,20);
        logger.info(field.get(fourthTask));







       // With This we get only public Fields
        Field[] secondF = exec.getFields();
//        logger.info(secondF[0].getName());
//        logger.info(Modifier.toString(secondF[0].getModifiers()));
//        logger.info(secondF[0].getType());

        // With this we acces Main Method,Public and all other modifiers method
        Method[] firstM = exec.getDeclaredMethods();
//        logger.info(Arrays.toString(firstM[0].getParameters()));
//        logger.info(Modifier.toString(firstM[1].getModifiers()));
//        logger.info(firstM[1].getName());
//        logger.info(firstM[1].getReturnType());

        // Here We get all the public methods
        Method[] secondM = exec.getMethods();

        // Here We get all constructors
        Constructor[] firstC = exec.getDeclaredConstructors();

        // Here We get only public constructors
        Constructor[] secondC = exec.getConstructors();
        Parameter[] params = secondC[0].getParameters();

    }
}
