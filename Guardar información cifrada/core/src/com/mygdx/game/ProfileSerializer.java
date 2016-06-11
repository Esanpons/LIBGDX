package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;

/**
 * Created by Zan on 11/06/2016.
 */
public class ProfileSerializer {

    private static final String PROFILE_DATA_FILE = ".roundWar/profile.dat";
    private static Profile profile;

    public static Profile read() {
        if( profile != null ) return profile;

        FileHandle profileDataFile = Gdx.files.local( PROFILE_DATA_FILE );
        Json json = new Json();

        if( profileDataFile.exists() ) {
            try {
                String profileAsCode = profileDataFile.readString();
                String profileAsText = Base64Coder.decodeString( profileAsCode );

                profile = json.fromJson( Profile.class, profileAsText );
            } catch( Exception e ) {
                System.out.println("Fallo al leer los datos: "+e);
                profile = new Profile();
                write( profile );
            }
        } else {
            profile = new Profile();
            write( profile );
        }
        return profile;
    }

    public static void write( Profile profile ) {
        Json json = new Json();
        FileHandle profileDataFile = Gdx.files.local( PROFILE_DATA_FILE );

        String profileAsText = json.toJson( profile );
        String profileAsCode = Base64Coder.encodeString( profileAsText );

        profileDataFile.writeString( profileAsCode, false );
    }
}
