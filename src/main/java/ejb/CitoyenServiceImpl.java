package ejb;

import javax.ejb.Stateless;
import model.Citoyen;
import model.Genre;

import java.sql.*;

@Stateless
public class CitoyenServiceImpl implements CitoyenService {
    private static final String URL = "jdbc:postgresql://localhost:5432/citoyen_presidence";
    private static final String USER = "nomena";
    private static final String PASSWORD = "root";

    @Override
    public Citoyen getCitoyen(String cin) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM v_citoyen_genre WHERE cin = ?");
            statement.setString(1, cin);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                // Créez et retournez un objet Citoyen à partir des résultats de la requête
                String id = resultSet.getString("citoyen_id");
                String nom = resultSet.getString("nom_citoyen");
                String prenom = resultSet.getString("prenom");
                String genre_id = resultSet.getString("genre_id");
                String nom_genre = resultSet.getString("nom_genre");
                Date dateNaissance = resultSet.getDate("date_naissance");

                Citoyen citoyen = new Citoyen();
                citoyen.setCitoyen_id(Integer.parseInt(id));
                citoyen.setNom(nom);
                citoyen.setPrenom(prenom);

                Genre genre = new Genre();
                genre.setGenre_id(Integer.parseInt(genre_id));
                genre.setNom(nom_genre);
                citoyen.setGenre(genre);

                citoyen.setDateNaissance(dateNaissance);
                citoyen.setCin(cin);

                return citoyen;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

