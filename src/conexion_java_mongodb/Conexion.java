// Autor: Iván Ornelas
// Fecha: 14 de febrero de 2021
// Descripción: Conexión a mongo usando "Mongo 2.9.3" jar
// Descarga del jar: 
// https://jar-download.com/artifacts/org.mongodb/mongo-java-driver/2.9.3/source-code
package conexion_java_mongodb;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject document = new BasicDBObject();
    
    public Conexion(){
        try {
            Mongo mongo = new Mongo("localhost",27017);
            // Nombre de la base de datos
            BaseDatos = mongo.getDB("conexion2");
            // Nombre de la colección en base de datos
            coleccion = BaseDatos.getCollection("ColeccionPrueba");
        } catch (UnknownHostException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
    public void insert(String clave, String valor){
        // Si se quiere insertar más de un campo agregar (.put)
        document.put(clave,valor);
        coleccion.insert(document);
    }
    
    public void read(){
        DBCursor cursor = coleccion.find();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
    
    public void update(String clave, String valor1, String valor2){
        // Cambiará el valor 1 por el valor 2
        document.put(clave,valor1);
        BasicDBObject documentoNuevo = new BasicDBObject();
        documentoNuevo.put(clave,valor2);
        coleccion.findAndModify(document, documentoNuevo);
    }
    
    public void delete(String clave, String valor){
        document.put(clave,valor);
        coleccion.remove(document);
    }
}
