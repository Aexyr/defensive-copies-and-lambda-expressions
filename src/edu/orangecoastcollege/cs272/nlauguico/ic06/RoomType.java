/**
 *
 */
package edu.orangecoastcollege.cs272.nlauguico.ic06;

/**
 * @author nlauguico
 *
 */
public enum RoomType
{
    TWO_DOUBLE_BEDS, TWO_QUEEN_BEDS, KING_BED;

    @Override
    public String toString() {
        return name().charAt(0) + name().replace('_', ' ').toLowerCase().substring(1);
    }
}
