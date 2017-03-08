/**
 *
 */
package edu.orangecoastcollege.cs272.nlauguico.ic06;

/**
 * @author nlauguico
 *
 */
public class Room
{
    private int mCapacity, mNumber;
    private RoomType mRoomType;

    /**
     * @param capacity
     * @param number
     * @param roomType
     */
    public Room(int capacity, int number, RoomType roomType)
    {
        mCapacity = capacity;
        mNumber = number;
        mRoomType = roomType;
    }

    /**
     * @return the capacity
     */
    public int getCapacity()
    {
        return mCapacity;
    }

    /**
     * @return the number
     */
    public int getNumber()
    {
        return mNumber;
    }

    /**
     * @return the roomType
     */
    public RoomType getRoomType()
    {
        return mRoomType;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + mCapacity;
        result = prime * result + mNumber;
        result = prime * result + ((mRoomType == null) ? 0 : mRoomType.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Room other = (Room) obj;
        if (mCapacity != other.mCapacity) return false;
        if (mNumber != other.mNumber) return false;
        if (mRoomType != other.mRoomType) return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Room [");
        builder.append(mNumber);
        builder.append(", ");
        builder.append(mCapacity);
        builder.append(" people, ");
        builder.append(mRoomType.toString());
        builder.append("]");
        return builder.toString();
    }


}
