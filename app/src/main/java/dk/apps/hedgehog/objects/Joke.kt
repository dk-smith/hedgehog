package dk.apps.hedgehog.objects

data class Joke(
    val id : Int,
    val joke : String,
    val categories : List<String>
)