//Boris de Leon 9959-24-6203

package Modelo.Logistica;

import Controlador.Logistica.clsCarreras;
import Controlador.clsUsuarioConectado;
import Modelo.Conexion;
import Modelo.BitacoraDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarrerasDAO {

    // INSERTAR
    public boolean insertar(clsCarreras obj) {

        String sql = "INSERT INTO carreras "
                + "(codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, obj.getCodigoCarrera());
            ps.setString(2, obj.getNombreCarrera());
            ps.setString(3, obj.getCodigoFacultad());
            ps.setString(4, obj.getEstatusCarrera());

            boolean resultado = ps.executeUpdate() > 0;

            if (resultado) {
                registrarBitacora("Insertó la carrera: " + obj.getNombreCarrera());
            }

            return resultado;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ACTUALIZAR
    public boolean actualizar(clsCarreras obj) {

        String sql = "UPDATE carreras SET "
                + "nombre_carrera=?, "
                + "codigo_facultad=?, "
                + "estatus_carrera=? "
                + "WHERE codigo_carrera=?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, obj.getNombreCarrera());
            ps.setString(2, obj.getCodigoFacultad());
            ps.setString(3, obj.getEstatusCarrera());
            ps.setString(4, obj.getCodigoCarrera());

            boolean resultado = ps.executeUpdate() > 0;

            if (resultado) {
                registrarBitacora("Actualizó la carrera: " + obj.getCodigoCarrera());
            }

            return resultado;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminar(String codigoCarrera) {

        String sql = "DELETE FROM carreras WHERE codigo_carrera=?";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, codigoCarrera);

            boolean resultado = ps.executeUpdate() > 0;

            if (resultado) {
                registrarBitacora("Eliminó la carrera: " + codigoCarrera);
            }

            return resultado;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // LISTAR
    public List<clsCarreras> listar() {

        List<clsCarreras> lista = new ArrayList<>();

        String sql = "SELECT * FROM carreras";

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                clsCarreras obj = new clsCarreras();

                obj.setCodigoCarrera(rs.getString("codigo_carrera"));
                obj.setNombreCarrera(rs.getString("nombre_carrera"));
                obj.setCodigoFacultad(rs.getString("codigo_facultad"));
                obj.setEstatusCarrera(rs.getString("estatus_carrera"));

                lista.add(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // BUSCAR POR CÓDIGO
    public clsCarreras buscarPorId(String codigoCarrera) {

        String sql = "SELECT * FROM carreras WHERE codigo_carrera=?";

        clsCarreras obj = null;

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, codigoCarrera);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                obj = new clsCarreras();

                obj.setCodigoCarrera(rs.getString("codigo_carrera"));
                obj.setNombreCarrera(rs.getString("nombre_carrera"));
                obj.setCodigoFacultad(rs.getString("codigo_facultad"));
                obj.setEstatusCarrera(rs.getString("estatus_carrera"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }

    // BITÁCORA
    private void registrarBitacora(String accion) {

        int usuario = clsUsuarioConectado.getUsuId();

        if (usuario == 0) {
            throw new RuntimeException("No hay usuario autenticado");
        }

        BitacoraDAO bitacora = new BitacoraDAO();

        int aplCodigoBitacora = 2018;

        bitacora.insert(usuario, aplCodigoBitacora, accion);
    }
}