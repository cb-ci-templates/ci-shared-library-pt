// vars/helloWorld.groovy
def call(String firstName,String lastName) {
    // you can call any valid step functions from your code, just like you can from Pipeline scripts
    echo "Hello ${firstName} ${lastName}"
    echo "Have a great day!"
}
