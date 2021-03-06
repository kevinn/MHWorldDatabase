package com.gatheringhallstudios.mhworlddatabase.data.types

/**
 * This file contains a collection of enumerations used in the MHWorld app.
 * These enums are automatically converted by Room via the rules set in "Converters.kt".
 */

/**
 * Denotes a quest rank. Mapped by the Converters class.
 */
enum class Rank {
    LOW,
    HIGH
}


enum class ItemCategory {
    ITEM,
    MATERIAL,
    AMMO,
    MISC,

    /** Cannot be queried in the item list, only directly. **/
    HIDDEN
}

enum class ItemSubcategory {
    NONE,
    APPRAISAL,
    ACCOUNT,
    SUPPLY,
    TRADE
}

/**
 * An enumeration used to represent a monster's size.
 * Created by Carlos on 3/21/2018.
 */
enum class MonsterSize {
    SMALL,
    LARGE
}

enum class Extract {
    RED,
    ORANGE,
    WHITE,
    GREEN
}

/**
 * An enumeration that defines where a piece of armor is worn.
 * Created by Carlos on 3/6/2018.
 */
enum class ArmorType {
    HEAD,
    CHEST,
    ARMS,
    WAIST,
    LEGS
}

/**
 * An enumeration that defines the type of weapon.
 * Created by Carlos on 3/20/2018.
 */
enum class WeaponType {
    GREAT_SWORD,
    LONG_SWORD,
    SWORD_AND_SHIELD,
    DUAL_BLADES,
    HAMMER,
    HUNTING_HORN,
    LANCE,
    GUNLANCE,
    SWITCH_AXE,
    CHARGE_BLADE,
    INSECT_GLAIVE,
    BOW,
    LIGHT_BOWGUN,
    HEAVY_BOWGUN
}

/**
 * Represents an object type.
 * Currently only used by search results for identification reasons.
 */
enum class DataType {
    LOCATION,
    ITEM,
    MONSTER,
    SKILL,
    DECORATION,
    CHARM,
    ARMOR,
    WEAPON
}