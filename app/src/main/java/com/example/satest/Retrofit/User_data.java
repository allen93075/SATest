package com.example.satest.Retrofit;

import java.util.List;

public class User_data  {


    /**
     * records : [{"id":"recfgeZOansiNUD5A","fields":{"Username":"Kevin Chao","User_id":"kevinichao","Account":["rec7hCaPLPEj6yrdR"],"Password":"12345678","Following":["recaga9ZOKEPLMA4E"],"Image":["recoCVJz3rIwJnt0l","rec7OG23uUAsgNE5t"],"email":"kevin.i.chao@gmail.com","Phone":"+886978877385"},"createdTime":"2019-05-20T21:31:26.000Z"},{"id":"recaga9ZOKEPLMA4E","fields":{"User_id":"allen93075"},"createdTime":"2019-05-20T21:31:26.000Z"},{"id":"recTrSEWMkhsHpOEb","fields":{},"createdTime":"2019-05-20T21:31:26.000Z"}]
     * offset : recTrSEWMkhsHpOEb
     */

    private String offset;
    //private List<RecordsBean> records;

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    //public List<RecordsBean> getRecords() {
    //    return records;
    //}

    //public void setRecords(List<RecordsBean> records) {
        //this.records = records;
    //}


        /**
         * id : recfgeZOansiNUD5A
         * fields : {"Username":"Kevin Chao","User_id":"kevinichao","Account":["rec7hCaPLPEj6yrdR"],"Password":"12345678","Following":["recaga9ZOKEPLMA4E"],"Image":["recoCVJz3rIwJnt0l","rec7OG23uUAsgNE5t"],"email":"kevin.i.chao@gmail.com","Phone":"+886978877385"}
         * createdTime : 2019-05-20T21:31:26.000Z
         */

        private String id;
        //private FieldsBean fields;
        private String createdTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        //public FieldsBean getFields() {
            //return fields;
        //}

        //public void setFields(FieldsBean fields) {
            //this.fields = fields;
        //}

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }


            /**
             * Username : Kevin Chao
             * User_id : kevinichao
             * Account : ["rec7hCaPLPEj6yrdR"]
             * Password : 12345678
             * Following : ["recaga9ZOKEPLMA4E"]
             * Image : ["recoCVJz3rIwJnt0l","rec7OG23uUAsgNE5t"]
             * email : kevin.i.chao@gmail.com
             * Phone : +886978877385
             */

            private String Username;
            private String User_id;
            private String Password;
            private String email;
            private String Phone;
            private List<String> Account;
            private List<String> Following;
            private List<String> Image;

            public String getUsername() {
                return Username;
            }

            public void setUsername(String Username) {
                this.Username = Username;
            }

            public String getUser_id() {
                return User_id;
            }

            public void setUser_id(String User_id) {
                this.User_id = User_id;
            }

            public String getPassword() {
                return Password;
            }

            public void setPassword(String Password) {
                this.Password = Password;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPhone() {
                return Phone;
            }

            public void setPhone(String Phone) {
                this.Phone = Phone;
            }

            public List<String> getAccount() {
                return Account;
            }

            public void setAccount(List<String> Account) {
                this.Account = Account;
            }

            public List<String> getFollowing() {
                return Following;
            }

            public void setFollowing(List<String> Following) {
                this.Following = Following;
            }

            public List<String> getImage() {
                return Image;
            }

            public void setImage(List<String> Image) {
                this.Image = Image;
            }


}
