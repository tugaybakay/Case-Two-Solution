public class Main {
    public static void main(String[] args) {
        execute(new String[]{"Robot", "step", "step", "getPos", "getDir", "step", "step", "step", "getPos","getDir"}
                ,new int[][]{{6, 3}, {2}, {2}, {}, {}, {2}, {1}, {4}, {}, {}});
    }

    public static void execute(String[] commands,int[][] numbers){
        Robot robot = null;
        Object[] output = new Object[commands.length];
        for(int i=0;i<commands.length;i++){
            switch (commands[i]){
                case "Robot":
                    robot = new Robot(numbers[0][0],numbers[0][1]);
                    output[i] = null;
                    break;
                case "step":
                    robot.step(numbers[i][0]);
                    output[i] = null;
                    break;
                case "getPos":
                    output[i] = robot.getPos();
                    break;
                case "getDir":
                    output[i] = robot.getDir();
                    break;
            }
        }

        for (Object obj : output){
            if(obj instanceof int[]){
                int[] list = (int[]) obj;
                System.out.println("["+list[0]+","+list[1]+"]");
            }else{
                System.out.println(obj);
            }
        }
    }
}