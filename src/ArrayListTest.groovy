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

    def "lastIndexOf test"() {
        given:
        ArrayList<String> testList = new ArrayList<>();
        def target = "target"

        for(int index=0; index < 5; index++) {
            testList.add(target)
        }

        when:
        def result = testList.lastIndexOf(target)

        then:
        result == 4
    }
    def "lastIndexOf test : not found"() {
        given:
        ArrayList<String> testList = new ArrayList<>();
        def target = "target"

        for(int index=0; index < 5; index++) {
            testList.add("doNotFind")
        }

        when:
        def result = testList.indexOf(target)

        then:
        result == -1
    }
    def "get test"() {
        given:
        ArrayList<String> testList = new ArrayList<>();
        def data = "target"

        for(int index = 0; index < 5; index++) {
            testList.add(data+index)
        }

        when:
        def result = testList.get(INDEX)

        then:
        result == EXPECTED

        where:
        EXPECTED | INDEX
        "target0"| 0
        "target1"| 1
        "target2"| 2
        "target3"| 3
        "target4"| 4
    }
    def "set test"() {
        given:
        ArrayList<String> testList = new ArrayList<>();
        def oldString = "originalData"
        def newString = "newData"

        for(int index=0; index < 5; index++) {
            testList.add(oldString)
        }

        when:
        def result = testList.set(2, newString)

        then:
        result == oldString
        testList.get(2) == newString
    }
    def "set test : Index out of bounds exception"() {
        given:
        ArrayList<String> testList = new ArrayList<>();
        def oldString = "originalData"
        def newString = "newData"

        for(int index=0; index < 5; index++) {
            testList.add(oldString)
        }

        when:
        testList.set(78, newString)

        then:
        thrown(IndexOutOfBoundsException.class)
    }
    def "remove test : Object"() {
        given:
        ArrayList<String> testList = new ArrayList<>()
        def text = "data"
        for(int index=0; index < 5; index++) {
            testList.add(text+index)
        }

        when:
        testList.remove(text+2)

        then:
        testList == List.of(text + 0, text+1, text+3, text+4)
    }
}
