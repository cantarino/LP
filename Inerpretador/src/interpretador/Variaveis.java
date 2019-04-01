package interpretador;

class Variaveis{
   public float[] var; //= new float[26];
   public Variaveis(){
       var = new float[26];
   }
   
   public void setVariavel(char variavel,float num){
       var[variavel-97] = num;
   }
   
   public float getVariavel(char variavel){
       return var[variavel-97];
   }
}