package ch12.annotation;

class NewClass {
    int newField;

    int getNewField() {
        return newField;
    }

    @Deprecated
    int oldField;

    @Deprecated
    int getOldField() {
        return oldField;
    }
}

class AnnotationEx02 {
    public static void main(String[] args) {
        NewClass nc = new NewClass();

        nc.oldField = 10;       //  @Deprected가 붙은 내용
        System.out.println(nc.getOldField());
    }
}
