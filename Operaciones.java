/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_teoriaconjuntos;

/**
 *
 * @author csegura
 */
public class Operaciones 
{

    private String [] Con_a, Con_b, Con_Res;
    private int Long_ConA, Long_ConB;

    public void ConjuntoCa(int LongA)
    {
        Long_ConA=LongA;
        Con_a= new String [Long_ConA];
    }
    
    public void ConjuntoCb(int LongB)
    {
        Long_ConB=LongB;
        Con_b= new String [Long_ConB];
    }
    
    //Metodos Set
    
    public void Ca(String Ca,int Indice)
    {
        Con_a[Indice] = Ca;
    }
    
    public void Ca(String []Ca)
    {
        Con_a=Ca;
    }
    
    public void Cb(String Cb,int Indice)
    {
        Con_b[Indice]=Cb;
    }
    
    public void Cb(String []Cb)
    {
        Con_b=Cb;
    }
    
    //Metodos Get
    
    public int Long_ConA()
    {
        return Long_ConA;
    }
    
    public int Long_ConB()
    {
        return Long_ConB;
    }
    
    public String Con_a(int Indice)
    {
        return Con_a[Indice];
    }
    
    public String [] Con_a()
    {
        return Con_a;
    }
    
    public String Con_b(int Indice)
    {
        return Con_b[Indice];
    }
    
    public String [] Con_b()
    {
        return Con_b;
    }
    
    //********* OPERACIONES DE CONJUNTOS ****************//
   
    /** Union **/
    public String Union()
    {
        int Contador=0;
        int Bandera=0;
        String Cadena=""; //Salida del resultado de la operacion de conjuntos
        
        //Lleno con datos del Conjunto A
        Con_Res = new String [Long_ConA + Long_ConB]; //Llena de Nullos Conjunto Resultante
        for (int i=0; i < Long_ConA; i++)
        {
           Con_Res[i]= Con_a[i];
        }
        
        //Almaceno posicion del Conjunto Resultante
        Contador = Long_ConA;
        //Comparo Repeticiones
        for (int i=0; i< Long_ConB; i++)
        {            
            Bandera=0;
            for (int j=0; j < Long_ConA + Long_ConB; j++)
            {
                if (Con_b[i].equals(Con_Res[j]))
                {
                    Bandera=1;  
                }
            }
            
            //Comparacion, si no existe se agrega al conjunto Resultado
            if (Bandera==0)
            {
                Con_Res[Contador] = Con_b[i];
                Contador++;
            }
        }
        
        //Llena String para Salida en Pantalla
        for (int i=0; i < Long_ConA + Long_ConB; i++)
           if (Con_Res[i] != null)
           Cadena = Cadena + Con_Res[i] + ";";
           return Cadena;
    }
   
    //Interceccion 
    public String Interseccion()
    {
        int Contador=0;
        int Bandera=0;
        String Cadena=""; //Salida de Pantalla
        
        Con_Res = new String [Long_ConA + Long_ConB];//Llena de Nullos Conjunto Resultante
        
        for (int i=0; i < Long_ConA; i++)
        {
            
            Bandera=0;
            for (int j=0; j < Long_ConB; j++){
                if (Con_a[i].equals(Con_b[j]))           
                  Bandera=1;
            }
            
            if (Bandera==1){
            Con_Res[Contador]= Con_a[i];
            Contador++;
            }
        }
        
        //Llena String para Salida en Pantalla
        for (int i=0;i<Long_ConA+ Long_ConB;i++)
            if (Con_Res[i]!=null)
                Cadena=Cadena+Con_Res[i]+";";
        
        return Cadena; 
    }
   
    //Diferencia
    
    public String Diferencia(){
        int Contador=0;
        int Bandera=0;
        String Cadena=""; //Salida de Pantalla
        Con_Res=new String [Long_ConA + Long_ConB];//Llena de Nullos Conjunto Resultante
        //Los no Repetidos de A
        for (int i=0;i<Long_ConA;i++){
            Bandera=0;
            for (int j=0;j<Long_ConB;j++){
                if (Con_a[i].equals(Con_b[j]))           
                  Bandera=1;  
            }
            if (Bandera==0){
            Con_Res[Contador]= Con_a[i];
            Contador++;
            }
        }
       
        //Llena String para Resultado de la operación
        for (int i=0;i< Long_ConA + Long_ConB;i++)
            if (Con_Res[i]!=null)
            Cadena= Cadena + Con_Res[i]+";";
        return Cadena; 
    }
    
    //Diferencia Simétrica
    public String DiferenciaSimetrica(){
        int Contador=0;
        int Bandera=0;
        String Cadena=""; //Salida de Pantalla
        Con_Res=new String [Long_ConA + Long_ConB];//Llena de Nullos Conjunto Resultante
        //Los no Repetidos de A
        for (int i=0;i< Long_ConA;i++){
            Bandera=0;
            for (int j=0;j< Long_ConB;j++){
                if (Con_a[i].equals( Con_b[j]))           
                  Bandera=1;  
            }
            if (Bandera==0){
            Con_Res[Contador]= Con_a[i];
            Contador++;
            }
        }
        //Los no Repetidos de B
        for (int i=0;i<Long_ConB;i++){
            Bandera=0;
            for (int j=0;j < Long_ConA;j++){
                if (Con_b[i].equals(Con_a[j]))           
                  Bandera=1;  
            }
            if (Bandera==0){
            Con_Res[Contador]=Con_b[i];
            Contador++;
            }
        }
        //Llena String para Salida en Pantalla
        for (int i=0; i < Long_ConA + Long_ConB; i++)
            if (Con_Res[i]!=null)
            Cadena=Cadena + Con_Res[i]+";";
        return Cadena;
    }

}
