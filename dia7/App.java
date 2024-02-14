import java.sql.*;

public class App {
   public static void main(String args[]) {
      Connection c = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/market", "postgres", "pqntslc");

//         topClientesFacturas(c);
//         topClientesGasto(c);
//         topMonedas(c);
//         topProveedor(c);
         topProductos(c);

      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      System.out.println("Opened database successfully");
   }

   public static void topClientesFacturas(Connection c) throws SQLException {
      try (Statement stmt = c.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT c.nombre || ' ' || c.apellido AS CLIENTE, " +
                   "COUNT(f.cliente_id) AS CANTIDAD_FACTURAS " +
                   "FROM factura f " +
                   "JOIN cliente c ON c.id = f.cliente_id " +
                   "GROUP BY c.nombre, c.apellido " +
                   "ORDER BY COUNT(f.cliente_id) DESC;")) {
         while (rs.next()) {
            System.out.println("Cliente: " + rs.getString("CLIENTE") +
                    ", Cantidad de Facturas: " + rs.getInt("CANTIDAD_FACTURAS"));
         }
      }
   }

   public static void topClientesGasto(Connection c) throws SQLException {
      try (Statement stmt = c.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT c.nombre || ' ' || c.apellido as CLIENTE, " +
                   "TO_CHAR(SUM(fd.cantidad * p.precio), '999,999,999,999.99') AS MONTO_GASTADO " +
                   "FROM factura f " +
                   "JOIN cliente c ON c.id = f.cliente_id " +
                   "JOIN factura_detalle fd ON fd.factura_id = f.id " +
                   "JOIN producto p ON p.id = fd.producto_id " +
                   "GROUP BY c.nombre, c.apellido " +
                   "ORDER BY SUM(fd.cantidad * p.precio) DESC;")) {
         while (rs.next()) {
            System.out.println("Cliente: " + rs.getString("CLIENTE") +
                    ", MONTO GASTADO: " + rs.getString("MONTO_GASTADO"));
         }
      }
   }

   public static void topMonedas(Connection c) throws SQLException {
      try (Statement stmt = c.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT m.nombre, " +
                   "COUNT(f.moneda_id) AS CANTIDAD " +
                   "FROM moneda m " +
                   "JOIN factura f ON f.moneda_id = m.id " +
                   "GROUP BY m.nombre, f.moneda_id " +
                   "ORDER BY COUNT(f.moneda_id) DESC;")) {
         while (rs.next()) {
            System.out.println("Moneda: " + rs.getString("nombre") +
                    ", Cantidad: " + rs.getString("CANTIDAD"));
         }
      }
   }

   public static void topProveedor(Connection c) throws SQLException {
      try (Statement stmt = c.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT prov.nombre, " +
                   "prov.ruc, " +
                   "COUNT(p.proveedor_id) AS CANTIDAD " +
                   "FROM proveedor prov " +
                   "JOIN producto p ON p.proveedor_id = prov.id " +
                   "GROUP BY prov.id, prov.nombre, prov.ruc " +
                   "ORDER BY COUNT(p.proveedor_id) DESC;")) {
         while (rs.next()) {
            System.out.println("Proveedor: " + rs.getString("nombre") +
                    ", RUC: " + rs.getString("ruc") + ", Cantidad: " + rs.getString("CANTIDAD"));
         }
      }
   }

   public static void topProductos(Connection c) throws SQLException {
      try (Statement stmt = c.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT p.nombre, SUM(fd.cantidad) AS CANTIDAD " +
                   "FROM producto p " +
                   "JOIN factura_detalle fd ON fd.producto_id = p.id " +
                   "GROUP BY p.id, p.nombre " +
                   "ORDER BY SUM(fd.cantidad) DESC")) {
         while (rs.next()) {
            System.out.println("Producto: " + rs.getString("nombre") +
                    ", Cantidad: " + rs.getString("CANTIDAD"));
         }
      }
   }

}