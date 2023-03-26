class ArrayListTest extends spock.lang.Specification {
    def "list isEmpty?" () {
        given:
        ArrayList<Integer> testList = new ArrayList<>();

        expect:
        testList.isEmpty();
    }

    def "list test : add" (){
        given:
        ArrayList<String> testList = new ArrayList<>();
        def text = "addSomething"
        when:
        testList.add(text);

        then:
        testList.size() == 1;
        testList.get(0) == text
        !testList.isEmpty()
    }
    def "list contains?" () {
        given:
        ArrayList<String> testList = new ArrayList<>();
        def text = "mustHaveThis"
        when:
        testList.add(text);

        then:
        testList.contains(text)
    }
    def "list toArray" () {
        given:
        ArrayList<Integer> testList = new ArrayList<>();
        for(int data = 0; data < 10; data++) {
            testList.add(data)
        }

        when:
        Integer[] array = testList.toArray() as Integer[]

        then:
        for(int data = 0; data < 10; data++) {
            array[data] == data;
        }
    }
    def "indexOf test"() {
        given:
        ArrayList<String> testList = new ArrayList<>();
        def target = "target"

        for(int index=0; index < 5; index++) {
            testList.add("doNotFind")
        }
        testList.add(target)

        when:
        def result = testList.indexOf(target)

        then:
        result == 5
    }
    def "indexOf test : not found"() {
        given:
        ArrayList<String> testList = new ArrayList<>();
        def target = "target"

        for(int index=0; index < 5; index++) {
            testList.add("doNotFind")
        }
        testList.add("cantFind")

        when:
        def result = testList.indexOf(target)

        then:
        result == -1
    }
}
