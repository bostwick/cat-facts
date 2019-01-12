package com.danielbostwick.catfacts.core

import com.danielbostwick.catfacts.core.model.CatFact
import com.danielbostwick.catfacts.core.model.CatFactAccount
import com.danielbostwick.catfacts.core.type.createDateNow
import com.danielbostwick.catfacts.core.type.createUuidFromString

object Fixtures {

    private val DATE_NOW = createDateNow()

    private val SYSTEM_ACCOUNT_ID = createUuidFromString("00000000-0000-0000-0000-000000000000")

    val ACCOUNTS = listOf(
        CatFactAccount(
            id = SYSTEM_ACCOUNT_ID,
            name = "Cat Facts",
            createdAt = DATE_NOW
        )
    )

    val CAT_FACTS = listOf(
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000001"),
            content = "The cat was seen as a sacred animial in ancient Eqypt, and the history of domestic cats dates back to as early as 8000 years.",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000002"),
            content = "The biggest breed of domesticated cats are called a Maine Coon cat and weighs up to 11 kg.",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000003"),
            content = "Cats are some of the smartest animals and can interpret a human's mood and feelings.",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000004"),
            content = "The average cat sleeps between 12-14 hours a day.",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000005"),
            content = "Cats paw (repeatedly treading on a spot - often it's owner) to mark their territory. Cats sweat through the bottom of their paws and rub this off as a marking mechanism.",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000006"),
            content = "Cats can be taught how to use the toilet.",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000007"),
            content = "White cats with blue eyes are quite often born deaf.",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000008"),
            content = "Cat urine glows in the dark if a black light is shined on it. This is a good way to detect cat urine in your home.",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000009"),
            content = "Cats have 220 degree field of view where humans only have 180°.",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-00000000000A"),
            content = "Cats' sense of smell is 14 times stronger than that of humans.",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-00000000000B"),
            content = "Cats have 30 permanent teeth, while adult humans have 32.",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-00000000000C"),
            content = "Cats have 30 vertebrae, while humans only have 25.",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-00000000000D"),
            content = "Cats have 230 bones in their bodies, this is 24 more than humans.",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-00000000000E"),
            content = "Cats have a body temperature of between 101 and 102.2 °F (38 and 39 °C).",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-00000000000F"),
            content = "The lifespan of cats are usually between 15 and 20 years.",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000010"),
            content = "Cats have a heart rate of between 120 - 240 beats per minute. (This varies highly between different breeds cats)",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000011"),
            content = "Cats take between 20 - 40 breaths per minute in an inactive state. (This varies highly between different breeds cats)",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000012"),
            content = "The print on a cat's nose is like that of a fingerprint of a human, each is unique.",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000013"),
            content = "Cats have a top speed of about 30 mp/h (48.28 km/h).",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000014"),
            content = "Cats Can Drink Salt Water because their kidneys are so efficient that the salt is removed and expelled from the body",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000015"),
            content = "Cats Rarely Meow at other Cats",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000016"),
            content = "Cats like their Water Bowl and Food in Separate Places",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000017"),
            content = "There are very few “true” Black Cats",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        ),
        CatFact(
            id = createUuidFromString("00000000-0000-0000-0000-000000000018"),
            content = "Most female cats are right pawed while more male cats are left pawed.",
            authorId = SYSTEM_ACCOUNT_ID,
            createdAt = DATE_NOW
        )
    )
}

