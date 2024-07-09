package de.gruppe5.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;
import java.util.prefs.Preferences;


// Savegame location HKEY_CURRENT_USER\Software\JavaSoft\Prefs


public class SaveableValue<Type> {

	Preferences prefs = Preferences.userNodeForPackage(Main.class);
	Type currentValue;
	String prefName;
	
	public SaveableValue(Type defaultValue, String name){
		this.prefName = name;
		
		try {
			this.currentValue = convertFromByteString(prefs.get(this.prefName, convertToByteString(defaultValue)));
		} catch (Exception e) {
			
		}
	}
	
	public void setValue(Type value) {
		try {
			prefs.put(this.prefName, convertToByteString(value));
			currentValue = value;
		} catch (IOException e) {
		}
	}
	
	public Type getValue() {
		return currentValue;
	}
	
	public String convertToByteString(Type object) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(object);
            final byte[] byteArray = bos.toByteArray();
            return Base64.getEncoder().encodeToString(byteArray);
        }catch (Exception e) {
        	
		}
        
        return "";
    }

	public Type convertFromByteString(String byteString) throws IOException, ClassNotFoundException {
        final byte[] bytes = Base64.getDecoder().decode(byteString);
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes); ObjectInputStream in = new ObjectInputStream(bis)) {
            return (Type)in.readObject();
        }catch (Exception e) {
        	
		}
        
        return null;
    }
}
