package android.sampleproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    private final int imageID;
    private final String name;
    private final String description;

    public Item(int imageID, String name, String description) {
        this.imageID = imageID;
        this.name = name;
        this.description = description;
    }

    protected Item(Parcel in) {
        imageID = in.readInt();
        name = in.readString();
        description = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public int getImageID() {
        return imageID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageID);
        dest.writeString(name);
        dest.writeString(description);
    }
}
