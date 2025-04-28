package com.example.Spring007D.Repository;

import com.example.Spring007D.Model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepository() {
     /*   users.add(new User(1,"User1","pass1","correo1@gmail.com"));
        users.add(new User(2,"User2","pass2","correo2@gmail.com"));
        users.add(new User(3,"User3","pass3","correo3@gmail.com"));
   */ }

    public String getUsers() {
        String output = "";
        for (User user : users) {
            output += "ID Usuario: " + user.getId() + "\n";
            output += "Nombre Usuario: " + user.getUsername() + "\n";
            output += "Contraseña: " + user.getPassword() + "\n";
            output += "Correo Usuario: " + user.getEmail() + "\n";
        }
        if (output.isEmpty()) {
            return "No se encontraron usuarios";
        } else {
            return output;
        }
    }

    public String getUser(int id) {
        String output = "";
        for (User user : users) {
            if (user.getId() == id) {
                output += "ID Usuario: " + user.getId() + "\n";
                output += "Nombre Usuario: " + user.getUsername() + "\n";
                output += "Contraseña: " + user.getPassword() + "\n";
                output += "Correo Usuario: " + user.getEmail() + "\n";
            }
        }
        if (output.isEmpty()) {
            return "No se encontro al usuario";
        } else {
            return output;
        }
    }

    public String addUser(User user) {
        users.add(user);
        return "Usuario agregado exitosamente";
    }

    public String deleteUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return "Usuario removido exitosamente";
            }
        }
        return "No se encontro al usuario";
    }

    public String updateUser(User user) {
        int index = 0;
        for (User temp : users) {
            if (temp.getId() == user.getId()) {
                index = users.indexOf(temp);
            }
        }
        if (index == -1) {
            return "No se encontro al usuario";
        } else {
            users.set(index, user);
            return "Usuario actualizado exitosamente";
        }
    }
}
