class ArrayListTest extends spock.lang.Specification {
    def "list isEmpty?" () {
        given:
        ArrayList<Integer> testList = new ArrayList<>();

        then:
        testList.isEmpty();
    }

    def "list test : add" (){
        given:
        ArrayList<String> testList = new ArrayList<>();
        def text = "addSomething"
        when:
        testList.add("addSomething");

        then:
        testList.size() == 1;
        testList.get(0) == text
        !testList.isEmpty()
    }
}
