import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head;

    // Add a new user to the list
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    // Find a user by User ID
    private User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
        }
        if (!user2.friendIds.contains(userId1)) {
            user2.friendIds.add(userId1);
        }

        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    // Remove a friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIds.remove(Integer.valueOf(userId2));
        user2.friendIds.remove(Integer.valueOf(userId1));

        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        List<Integer> mutualFriends = new ArrayList<>(user1.friendIds);
        mutualFriends.retainAll(user2.friendIds);

        if (mutualFriends.isEmpty()) {
            System.out.println("No mutual friends between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
            for (int id : mutualFriends) {
                User mutualFriend = findUserById(id);
                if (mutualFriend != null) {
                    System.out.println(mutualFriend.name);
                }
            }
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        User user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        for (int friendId : user.friendIds) {
            User friend = findUserById(friendId);
            if (friend != null) {
                System.out.println(friend.name);
            }
        }
    }

    // Search for a user by Name or User ID
    public void searchUser(String name, Integer userId) {
        User temp = head;
        boolean found = false;

        while (temp != null) {
            if ((name != null && temp.name.equalsIgnoreCase(name)) || (userId != null && temp.userId == userId)) {
                System.out.println("User Found: " + temp.name + " (ID: " + temp.userId + ", Age: " + temp.age + ")");
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("User not found.");
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        User temp = head;

        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMedia socialMedia = new SocialMedia();

        socialMedia.addUser(1, "Alice", 25);
        socialMedia.addUser(2, "Bob", 30);
        socialMedia.addUser(3, "Charlie", 28);
        socialMedia.addUser(4, "Diana", 22);

        socialMedia.addFriendConnection(1, 2);
        socialMedia.addFriendConnection(1, 3);
        socialMedia.addFriendConnection(2, 3);
        socialMedia.addFriendConnection(3, 4);

        socialMedia.displayFriends(1);
        socialMedia.findMutualFriends(1, 3);

        socialMedia.removeFriendConnection(1, 2);
        socialMedia.displayFriends(1);

        socialMedia.searchUser("Charlie", null);
        socialMedia.countFriends();
    }
}