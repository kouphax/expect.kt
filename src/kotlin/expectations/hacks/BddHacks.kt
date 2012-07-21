package kotlin.expectations

// cheap hacks for heroes!
public fun describe(val description: String, val block: () -> Unit){ println(description); block() }
public fun it(val description: String, val block: () -> Unit){
    try{
        block()
        println("\t $description - ✔")
    }catch(e: Error){
        println("\t $description - ✘")
        throw e
    }
}