import com.sun.istack.internal.NotNull;

/**
 * Created by Frank Fang on 8/18/18.
 */
public class User {

    private final String id;
    private final String userName;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String cellphoneNumber;
    private String email;


    public enum Gender{

        Male("Male"),
        Female("Female"),
        Unknown("Unknown");

        private String mGender;

        Gender(String gender){
            mGender = gender;
        }

        public String toString(){
            return mGender;
        }
    }

    public User(@NotNull final String userName, @NotNull final String id){
        this.userName = userName;
        this.id = id;
    }

    private User(UserBuilder b) {
        id = b.id;
        userName = b.userName;
        firstName = b.firstName;
        lastName = b.lastName;
        gender = b.gender;
        cellphoneNumber = b.cellphoneNumber;
        email = b.email;
    }

    public int hashCode(){
        final int prime = 31;
        int result = 0;

        result = result * prime + id.hashCode();
        result = result * prime + userName.hashCode();
        result = result * prime + (firstName == null ? 0 : firstName.hashCode());
        result = result * prime + (lastName == null ? 0 : lastName.hashCode());
        result = result * prime + (gender == null ? 0 : gender.toString().hashCode());
        result = result * prime + (cellphoneNumber == null ? 0 : cellphoneNumber.hashCode());
        result = result * prime + (email == null ? 0 : email.hashCode());

        return result;
    }

    public boolean equals(Object o){
        if(!(o instanceof User)) return false;

        final User tempUser = (User) o;

        return (id.equals(tempUser.id)) && (userName.equals(tempUser.userName));//.............
    }



    public static class UserBuilder{

        private final String id;
        private final String userName;
        private String firstName;
        private String lastName;
        private Gender gender;
        private String cellphoneNumber;
        private String email;

        public UserBuilder(@NotNull final String userName, @NotNull final String id){
            this.userName = userName;
            this.id = id;
        }

        public UserBuilder withFirstName(final String firstName){
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withLastName(final String lastName){
            this.lastName = lastName;
            return this;
        }

        public UserBuilder withGender(final Gender gender){
            this.gender = gender;
            return this;
        }

        public UserBuilder withCellphoneNumber(final String cellphoneNumber){
            this.cellphoneNumber = cellphoneNumber;
            return this;
        }

        public UserBuilder withEmail(final String email){
            this.email = email;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
