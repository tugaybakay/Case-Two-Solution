public class Robot {
    int x;
    int y;
    byte dir; // Doğu-0 , Kuzey-1 , Batı-2 , Güney-3
    int [][]map;
    int width;
    int height;

    public Robot(int width,int height){
        x = 0; //Robotun ilk pozisyonu 0,0
        y = 0;
        dir = 0; // ilk yön doğu
        this.width = width; // robotu ilerlettiğimizde robotun konumunun sınırlara gelip gelmediğini kontrol etmek için genişliği ve yüksekliği bir değişkende tutuyorum
        this.height = height;
        map = new int[width][height];
    }

    public void step(int step){

        switch (dir){
            case 0://Doğu
                goRight(step);
                break;
            case 1://Kuzey
                goUp(step);
                break;
            case 2://Batı
                goLeft(step);
                break;
            case 3://Güney
                goDown(step);
                break;
        }
    }

    public int[] getPos(){
        return new int[]{this.x,this.y};
    }

    public String getDir(){

        switch (dir){
            case 0:
                return "Doğu";
            case 1:
                return "Kuzey";
            case 2:
                return "Batı";
            case 3:
                return "Güney";
            default:
                return null;
        }
    }

    private void goRight(int step){
        //Eğer robot haritanın en doğusunda değil ise doğuya ilerler , en doğusunda ise yönü kuzeye döner ve goUp fonksiyonu çağrılır
        for(;step>0;step--){
            if(x != width-1){
                x++;
            }else{
                dir++;
                goUp(step);
                break;
            }
        }
    }

    private void goUp(int step){
        //Eğer robot haritanın en kuzeyinde değil ise kuzeye ilerler , en kuzeyinde ise yönü batıya döner ve goLeft fonksiyonu çağrılır
        for(;step>0;step--){
            if(y != height-1){
                y++;
            }else{
                dir++;
                goLeft(step);
                break;
            }
        }
    }

    private void goLeft(int step){
        //Eğer robot haritanın en batısında değil ise batıya ilerler , en batısında ise yönü güneye döner ve goDown fonksiyonu çağrılır
        for(;step>0;step--){
            if(x>0){
                x--;
            }else{
                dir++;
                goDown(step);
                break;
            }
        }
    }

    private void goDown(int step){
        //Eğer robot haritanın en güneyinde değil ise güneye ilerler , en güneyde ise yönü doğuya döner ve goRight fonksiyonu çağrılır
        for(;step>0;step--){
            if(y>0){
                y--;
            }else{
                dir = 0;
                goRight(step);
                break;
            }
        }
    }
}
