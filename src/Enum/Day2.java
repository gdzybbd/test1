package Enum;

enum Day2 {
    First{
        @Override
        public String getInfo() {
            return "first";
        }
    },

    Second{
        @Override
        public String getInfo() {
            return "second";
        }
    }
    ;
    public abstract String getInfo();

}
