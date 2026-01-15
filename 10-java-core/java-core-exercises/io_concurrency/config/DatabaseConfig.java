package io_concurrency.config;

import java.io.*;

public class DatabaseConfig implements Externalizable {

    private String host;
    private int port;
    private String username;
    private String password;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(host);
        out.writeInt(port);
        out.writeUTF(username);
        out.writeUTF(new StringBuilder(password).reverse().toString());
    }

    @Override
    public void readExternal(ObjectInput in)
            throws IOException {
        host = in.readUTF();
        port = in.readInt();
        username = in.readUTF();
        password = new StringBuilder(in.readUTF()).reverse().toString();
    }
}
