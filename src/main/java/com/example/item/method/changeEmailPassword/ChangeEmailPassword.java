package com.example.item.method.changeEmailPassword;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChangeEmailPassword {
    private Connection conn = null;
    private boolean hasError = false;
    private String ErrorMessage = "";
    private boolean isSuccessfully = false;
    private String SystemMessage = "";


    public boolean isHasError() {
        return hasError;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String msg) {
        hasError = true;
        this.ErrorMessage = msg;
    }

    public ChangeEmailPassword(String host, Integer port, String username, String oldPassword) {
        try {
            conn = new Connection(host, port);
            conn.connect();
            boolean isAuthenticated = conn.authenticateWithPassword(username, oldPassword);
            if (!isAuthenticated) {
                setErrorMessage("Authentication failed.");
                conn = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            conn.close();
            conn = null;
        }
    }

    public void setNewPassword(String newPassword) {
        if (hasError) {
            return;
        }
        if (conn == null) {
            return;
        }
        try {
            Session sess = conn.openSession();
            sess.execCommand("passwd");
            InputStream so = sess.getStdout();
            InputStream err = sess.getStderr();
            OutputStream out = sess.getStdin();

            byte[] buffer = new byte[500];//其实没有必要这么大.130就差不多了.怕万一有什么提示.
            int length;
            length = err.read(buffer);
            if (length > 0) {
                System.out.println("#1:" + new String(buffer, 0, length));
            }
            String coldPassword = newPassword + "\n";
            out.write(coldPassword.getBytes());
            length = err.read(buffer);
            if (length > 0) {
                System.out.println("#2:" + new String(buffer, 0, length));
                //(current) UNIX password:
            }
            String cNewPass = newPassword + "\n";
            out.write(cNewPass.getBytes());
            length = err.read(buffer);
            if (length > 0) {
                String rs = new String(buffer, 0, length);
                System.out.println("#3:" + rs);
                if (rs.contains("BAD") || rs.contains("Sorry")) {
                    sess.close();
                    conn.close();
                    setErrorMessage(rs);
                    return;
                }
            }
            out.write(cNewPass.getBytes());
            length = err.read(buffer);
            if (length > 0) {
                String rs = new String(buffer, 0, length);
                System.out.println("#4:" + rs);
                if (rs.contains("BAD") || rs.contains("Sorry")) {
                    sess.close();
                    conn.close();
                    setErrorMessage(rs);
                    return;
                }
            }
            out.write(cNewPass.getBytes());
            length = so.read(buffer);
            if (length > 0) {
                String rs = new String(buffer, 0, length);
                if (rs.contains("successfully")) {
                    this.isSuccessfully = true;
                    this.SystemMessage = rs;
                }
            }
            sess.close();
            conn.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    public static void main(String[] args) {
        ChangeEmailPassword cep = new ChangeEmailPassword("136.6.5.45", 22, "cxyftoods2", "GHdsdui8963%^$");
        if (cep.isHasError()) {
            System.out.println(cep.getErrorMessage());
            return;
        }
        cep.setNewPassword("Qywx,.2020");
        if (cep.isHasError()) {
            System.out.println(cep.getErrorMessage());
            return;
        }
        if (cep.isSuccessfully) {
            System.out.println(cep.getSystemMessage());
        }
    }

    public String getSystemMessage() {
        return SystemMessage;
    }

}
