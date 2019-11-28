/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DAM 6N
 */
public class CancionPirata implements Runnable{
private String[] hilo;

    public CancionPirata(String[] hilo) {
        this.hilo=hilo;
    }
    public void run(){
        for (int i = 0; i < hilo.length; i++) {
            System.out.println(hilo[i]);
			try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
				throw new IllegalStateException(e);
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
String[] cancion={"Con diez cañones por banda,"
,"viento en popa, a toda vela,"
,"no corta el mar, sino vuela,"
,"mi velero bergantin:"
,"Bajel pirata que llaman,"
,"por su bravura, el Temido,"
,"en todo mar conocido,"
,"del uno al otro confin."
,""
,"La luna en el mar riela,"
,"en la lona gime el viento,"
,"y alza en blando movimiento"
,"olas de plata y azul;"
,"y ve el capitan pirata,"
,"cantando alegre en la popa,"
,"Asia a un lado, al otro Europa,"
,"y alla a su frente Stambu"
,""
,"«Navega, velero mio,"
,"sin temor,"
,"que ni enemigo navio"
,"ni tormenta, ni bonanza"
,"tu rumbo a torcer alcanza,"
,"ni a sujetar tu valor."
,""
,"»Veinte presas"
,"hemos hecho"
,"a despecho"
,"del ingles,"
,"y han rendido"
,"sus pendones"
,"cien naciones"
,"a mis pies.»"
,""
,"»Que es mi barco mi tesoro,"
,"Que es mi Dios la libertad,"
,"Mi ley, la fuerza y el viento,"
,"Mi unica patria, la mar."
,""
,"»Alla muevan feroz guerra,"
,"ciegos reyes"
,"por un palmo mas de tierra;"
,"que yo tengo aqui por mio"
,"cuanto abarca el mar bravio,"
,"a quien nadie impuso leyes."
,""
,"»Y no hay playa,"
,"sea cualquiera,"
,"ni bandera"
,"de esplendor,"
,"que no sienta"
,"mi derecho"
,"y de pecho"
,"a mi valor.»"
,""
,"Que es mi barco mi tesoro,"
,"que es mi dios la libertad,"
,"mi ley, la fuerza y el viento,"
,"mi unica patria, la mar."
,""
,"»A la voz de «¡barco viene!»"
,"es de ver"
,"como vira y se previene,"
,"a todo trapo a escapar;"
,"que yo soy el rey del mar,"
,"y mi furia es de temer."
,""
,"»En las presas"
,"yo divido"
,"lo cogido"
,"por igual;"
,"solo quiero"
,"por riqueza"
,"la belleza"
,"sin rival."
,""
,"Que es mi barco mi tesoro,"
,"Que es mi dios la libertad,"
,"Mi ley, la fuerza y el viento,"
,"Mi unica patria, la mar."
,""
,"»¡Sentenciado estoy a muerte!"
,"Yo me rio;"
,"no me abandone la suerte,"
,"y al mismo que me condena,"
,"colgare de alguna entena,"
,"quiza en su propio navio."
,""
,"»Y si caigo,"
,"¿que es la vida?"
,"Por perdida"
,"ya la di,"
,"cuando el yugo"
,"del esclavo,"
,"como un bravo,"
,"sacudi."
,""
,"Que es mi barco mi tesoro,"
,"Que es mi dios la libertad,"
,"Mi ley, la fuerza y el viento,"
,"Mi unica patria, la mar."
,""
,"»Son mi musica mejor"
,"aquilones,"
,"el estrepito y temblor"
,"de los cables sacudidos,"
,"del negro mar los bramidos"
,"y el rugir de mis cañones."
,""
,"»Y del trueno"
,"al son violento,"
,"y del viento"
,"al rebramar,"
,"yo me duermo"
,"sosegado,"
,"arrullado"
,"por la mar."
,""
,"Que es mi barco mi tesoro,"
,"que es mi dios la libertad,"
,"mi ley, la fuerza y el viento,"
,"mi unica patria, la mar. "
};
CancionPirata h=null;
        
            h=new CancionPirata(cancion);
			new Thread(h).start();
            
        
    }
    
}
