//https://www.codewars.com/kata/515bb423de843ea99400000a/train/java

/*For this exercise you will be strengthening your page-fu mastery. 
You will complete the PaginationHelper class, which is a utility class 
helpful for querying paging information related to an array.

The class is designed to take in an array of values and an integer 
indicating how many items will be allowed per each page. The types of 
values contained within the collection/array are not relevant.

The following are some examples of how this class is used:

PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
helper.pageCount(); // should == 2
helper.itemCount(); // should == 6
helper.pageItemCount(0); // should == 4
helper.pageItemCount(1); // last page - should == 2
helper.pageItemCount(2); // should == -1 since the page is invalid

// pageIndex takes an item index and returns the page that it belongs on
helper.pageIndex(5); // should == 1 (zero based index)
helper.pageIndex(2); // should == 0
helper.pageIndex(20); // should == -1
helper.pageIndex(-10); // should == -1 */

import java.util.List;

// TODO: complete this object/class

public class PaginationHelper<I> {
    private List<I> collection;
    private int itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        int infer = itemCount() % itemsPerPage;
        int pages = itemCount() / itemsPerPage;
        return infer > 0 ? pages + 1 : pages;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex >= pageCount() || pageIndex < 0) {
            return -1;
        } else if (itemCount() % itemsPerPage == 0) { //actually forgrt this situation at first
            return itemsPerPage;
        }
        return pageIndex == pageCount() - 1 ? itemCount() % itemsPerPage : itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex >= itemCount() || itemIndex < 0) {
            return -1;
        }
        return itemIndex / itemsPerPage;
    }
}