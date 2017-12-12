import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

fun main(args: Array<String>) {
    //Verbinden
    var connection: Connection? = null
    try {
        val url = "org.sqlite.JDBC"
        val urlcon = "jdbc:sqlite:db.db"

        Class.forName(url)
        connection = DriverManager.getConnection(urlcon)
    } catch (ex: ClassNotFoundException) {
        println("No JDBC"+ex)
    } catch (ex: SQLException) {
        println("Fehler Verbindung"+ex)
    }
    //Query
    val liste = arrayListOf<db>()

    try {
        val st = connection?.createStatement()
        val sql = "Select * From table1"
        val rs = st?.executeQuery(sql)

        while (rs!!.next()) {
            val c = db(
                    rs.getInt("Field1"),
                    rs.getInt("Field2")
            )
            liste.add(c)
        }
        println(liste)
    } catch (ex: SQLException) {
        println("Error daten"+ex)
    }
    connection?.close()

}

