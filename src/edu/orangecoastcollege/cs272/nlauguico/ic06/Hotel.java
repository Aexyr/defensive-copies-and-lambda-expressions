/**
 *
 */
package edu.orangecoastcollege.cs272.nlauguico.ic06;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author nlauguico
 *
 */
public class Hotel
{
    private String mName;
    private List<Room> mAllRoomList;
    private List<Room> mAvailableRoomsList;
    private List<Room> mOccupiedRoomsList;

    private List<Room> filter(List<Room> rooms, Predicate<Room> predicate)
    {
        // .stream() makes a copy for searching
        // .filter(param) filters the results base on the param condition
        // Collectors determines how results will be collected (In this case its toList())
        return rooms.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    } // Will return a List of all rooms matching the predicate.

    private Predicate<Room> matchType(RoomType type)
    {
        // Lambda expressions have "ghost variables" (w in this case)
        // in Lambda the ghost variables always points to the type of whatever is inside the tag <>
        return r -> r.getRoomType() == type;
    } // Will return a Predicate (condition) of Rooms that have the RoomType type.

    /**
     * @param allRoomList
     * @param availableRoomsList
     * @param occupiedRoomsList
     * @param name
     */
    public Hotel(String name, List<Room> allRoomList)
    {
        mName = name;
        mAllRoomList = new ArrayList<Room>(allRoomList);
        mAvailableRoomsList = new ArrayList<Room>(allRoomList);
        mOccupiedRoomsList = new ArrayList<Room>();
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return mName;
    }

    /**
     * @return the allRoomList
     */
    public List<Room> getAllRoomList()
    {
        return new ArrayList<Room>(mAllRoomList);
    }

    /**
     * @return the availableRoomsList
     */
    public List<Room> getAvailableRoomsList()
    {
        return new ArrayList<Room>(mAvailableRoomsList);
    }

    /**
     *
     * @param Room Type
     * @return the list filtered with the type
     */
    public List<Room> getAvailableRoomsListMatching(RoomType type)
    {
        List<Room> availableRooms = this.filter(mAvailableRoomsList, matchType(type));
        return availableRooms;
    }

    /**
     * @return the occupiedRoomsList
     */
    public List<Room> getOccupiedRoomsList()
    {
        return new ArrayList<Room>(mOccupiedRoomsList);
    }

    public boolean bookRoom(RoomType type)
    {
        List<Room> availableRooms = getAvailableRoomsListMatching(type);

        if (!availableRooms.isEmpty())
        {
            Room tempRoom = availableRooms.get(0);
            mOccupiedRoomsList.add(tempRoom);
            mAvailableRoomsList.remove(tempRoom);
            return true;
        }

        return false;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mAllRoomList == null) ? 0 : mAllRoomList.hashCode());
        result = prime * result + ((mAvailableRoomsList == null) ? 0 : mAvailableRoomsList.hashCode());
        result = prime * result + ((mName == null) ? 0 : mName.hashCode());
        result = prime * result + ((mOccupiedRoomsList == null) ? 0 : mOccupiedRoomsList.hashCode());
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
        Hotel other = (Hotel) obj;
        if (mAllRoomList == null)
        {
            if (other.mAllRoomList != null) return false;
        }
        else if (!mAllRoomList.equals(other.mAllRoomList)) return false;
        if (mAvailableRoomsList == null)
        {
            if (other.mAvailableRoomsList != null) return false;
        }
        else if (!mAvailableRoomsList.equals(other.mAvailableRoomsList)) return false;
        if (mName == null)
        {
            if (other.mName != null) return false;
        }
        else if (!mName.equals(other.mName)) return false;
        if (mOccupiedRoomsList == null)
        {
            if (other.mOccupiedRoomsList != null) return false;
        }
        else if (!mOccupiedRoomsList.equals(other.mOccupiedRoomsList)) return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        int maxOccupancy = (this.filter(mAllRoomList, matchType(RoomType.KING_BED)).size() * 2) +
                           (this.filter(mAllRoomList, matchType(RoomType.TWO_DOUBLE_BEDS)).size() * 2) +
                           (this.filter(mAllRoomList, matchType(RoomType.TWO_QUEEN_BEDS)).size() * 4);

        int currentOccu = (this.filter(mOccupiedRoomsList, matchType(RoomType.KING_BED)).size() * 2) +
                          (this.filter(mOccupiedRoomsList, matchType(RoomType.TWO_DOUBLE_BEDS)).size() * 2) +
                          (this.filter(mOccupiedRoomsList, matchType(RoomType.TWO_QUEEN_BEDS)).size() * 4);

        StringBuilder builder = new StringBuilder();
        builder.append("~~~");
        builder.append(mName);
        builder.append("~~~\n\n\n");
        builder.append("Occupied Rooms : ");
        builder.append(mOccupiedRoomsList.size());
        builder.append("\nAvailable Rooms : ");
        builder.append(mAvailableRoomsList.size());
        builder.append("\nTotal Rooms : ");
        builder.append(mAllRoomList.size());
        builder.append("\n\n----------------------\n\n");
        builder.append("Current Occupancy : ");
        builder.append(currentOccu);
        builder.append("\nMax Occupancy : ");
        builder.append(maxOccupancy);
        builder.append("\nOccupancy Rate : ");
        builder.append((currentOccu * 100)/maxOccupancy);
        builder.append("%");
        return builder.toString();
    }
}
