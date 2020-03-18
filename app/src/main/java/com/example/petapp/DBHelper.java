package com.example.petapp;

import java.util.List;

public class DBHelper {
    List<Pet> pets;
    List<Food> foods;

    public List<Pet> initialisePets(){
        pets.add(new Pet("Beagle", "Dog", "beagle", "12-15 years", "Male: 10-11kg, Female: 9-10kg", "" +
                "Beagles are great family pets but due to their strong hunting instincts they might not be the best dogs for homes with smaller pets. Beagles tend to be very tolerant and accepting by nature and so will fit into family life perfectly if well socialised from a young age.\n" +
                "\n" +
                "Their size and affectionate personalities make Beagles a popular family pet but they can be quite high energy so always supervise your Beagle with children. Like any dog, they can be destructive when bored so make sure to keep their mind active with training and lots of exercise.",
                "Beagles can be mischievous characters so it’s important to start positive, reward-based training as soon as possible to prevent them picking up bad habits. They are very intelligent dogs and are known to be wilful so you will need a firm but fair attitude when training – as always, consistency is key. " +
                "If you aren’t an experienced trainer, or are a first-time dog owner, then you should ask for the help of an accredited trainer.",
                "Beagles tend to be quite high energy and you’ll find they enjoy being part of everything their owners do. Whether you live in a city or the countryside, your Beagle will still need plenty of exercise to keep them happy and healthy. Beagles are good escape artists and love to climb and dig, so make sure your garden is Beagle-proof!\n" +
                "\n" +
                "Your Beagle will need at least an hour and a half of exercise a day. We’d recommend a combination of walking and running for this. In addition, they’ll also need playtime, training and free time in a secure garden. Beagles are scent hounds, so they’ll really enjoy playing scent games with you and getting the chance to use their keen sense of smell.",
                1, 2, 3));
        pets.add(new Pet("Bulldog", "Dog", "bulldog", "8-10 years","Male: 23-25kg, Female: 18-23kg", "" +
                "Bulldogs are sweet, devoted, and easygoing, and they want to please their owner. As with all breeds, early socialization is vital to help give the dog a good start in life. Puppy training classes are highly recommended as well and allow the owner to learn how to curb any undesirable behaviors. Bulldogs love to chew—most will enjoy chew toys their entire life. ",
                "Bulldogs are mellow and are happy to relax next to their owner’s feet, but they also enjoy an occasional romp and going on walks. Moderate exercise will help the dog to stay trim. Very warm days are best spent in front of an air-conditioner, however, as the Bulldog’s short muzzle can make breathing difficult in heat and humidity." +
                 " Stairs and pools also present major safety hazards. ",
                "An all-over brushing with a soft brush for 10 minutes two or three times a week will keep the Bulldog looking his best. During periods of heavier shedding, it can help to first use a rubber curry brush. The wrinkles on the Bulldog’s face need to be regularly checked to make sure the skin is clean and dry, as food or moisture can get trapped and cause irritation or infection.",
                1,2,3));
        pets.add(new Pet("Golden Retriever", "Dog", "golden", "10-12 years", "Male: 30-34kg, Female: 25-32kg", "Golden retrievers have an outgoing, devoted, and friendly personality, making this type of dog a great addition to any family. They maintain a playful and energetic approach to life longer than some other breeds, so be ready to play lots of " +
                "fetch with your golden retriever!",
                "Golden retrievers are also incredibly intelligent and eager to please, which makes them easy to train. Basic obedience and house-training skills, including potty training and not digging, should be taught when your golden retriever is a puppy. With more advanced training, golden retrievers can serve as guide dogs for the blind, rescue dogs, and hunting dogs.",
                " Golden retrievers need plenty of exercise; they love playing outdoors and swimming. As far as care, the golden retriever has a thick, water-repellent double-coat, which can be wavy or straight. Its coat needs to be brushed twice a week to help control shedding. Golden retrievers have strong, fast-growing nails that require regular trimming or grinding to prevent overgrowth, splitting, and cracking. ",
                1,2,3));
        pets.add(new Pet("Shiba Inu", "Dog", "shiba", "12-15 years", "Male: 8-11kg, 6.8-9kg", "Considered highly trainable and easier to housebreak, you won’t find many troubles with the Shiba Inu. It can be stubborn at times, because of its confidence and strong instincts, but if you demonstrate that you’re the pack leader, there should be no problems keeping your dog on a strict discipline program.",
                "The most common health problems of the Shiba Inu relate to joint problems, which is not rare for dogs but a little unusual for dogs of its size. You might even notice kneecap problems in this dog, not a common problem in other dogs.",
                "Though small, the Shiba Inu has a surprising thirst for some forms of exercise and will be able to catch up with you easily if you take it out often. Regular walking should be considered a normal habit, and certainly something you’ll want to get into with any dog. The breed might also want to get away from you at times to explore natural landscapes.",
                1,2,3));
        pets.add(new Pet("Dobermann", "Dog", "dober", "10-13 years", "Male: 40-45kg, Female: 32-35kg", "Keep your Doberman indoors during cold weather, as he can chill easily because of his short coat. Purchase a dog sweater or coat for him when walking him in cold conditions.\n" +
                "Give your Doberman interactive toys, such as treat-containing chew toys, to engage his mind during the day when you are not home. This prevents destructive behavior in this breed from developing.",
                "Take your Doberman for regular vet visits to check for certain conditions that are more prevalent in this breed including cancer, hyperthyroidism, hip dysplasia, Von Willebrand's disease and dilated cardiomyopathy.", "" +
                "If you cannot play with or exercise your Doberman outdoors as much as he needs, run him on a treadmill to ensure he gets the exercise he needs to prevent compulsive or destructive behaviors.\n" +
                "Socialize your Doberman from an early age to prevent any issues with aggression later in life toward other people or dogs. Have your young Doberman play with other dogs and expose him to a variety of other people starting at 12 weeks old.\n" +
                "This intelligent, obedient dog can be trained to be a guide dog for the blind with a certified guide dog instructor.",
                1, 2,3));
        return pets;
    }

    public List<Food> initializeFood(){

        return foods;
    }

}
