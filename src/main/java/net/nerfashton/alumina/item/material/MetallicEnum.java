package net.nerfashton.alumina.item.material;


import java.util.ArrayList;

public enum MetallicEnum {
    ALUMINUM,
    AMERICIUM,
    ANTIMONY,
    BARIUM,
    BERYLLIUM,
    BISMUTH,
    CADMIUM,
    CALCIUM,
    CERIUM,
    CESIUM,
    CHROMIUM,
    COBALT,
    //COPPER,
    DYSPROSIUM,
    ERBIUM,
    EUROPIUM,
    GADOLINIUM,
    GALLIUM,
    //GOLD,
    GERMANIUM, //maybe won't use this one idk
    HAFNIUM,
    HOLMIUM,
    INDIUM,
    IRIDIUM,
    //IRON,
    LANTHANUM,
    LEAD,
    LITHIUM,
    LUTETIUM,
    MAGNESIUM,
    MANGANESE,
    MERCURY,
    MOLYBDENUM,
    NEODYMIUM,
    NEPTUNIUM,
    NICKEL,
    NIOBIUM,
    OSMIUM,
    PALLADIUM,
    PLATINUM,
    PLUTONIUM,
    POLONIUM,
    POTASSIUM,
    PRASEODYMIUM,
    PROMETHIUM,
    PROTACTINIUM,
    RADIUM,
    RHENIUM,
    RHODIUM,
    RUBIDIUM,
    RUTHENIUM,
    SAMARIUM,
    SCANDIUM,
    SELENIUM,
    SILVER,
    SODIUM,
    STRONTIUM,
    TANTALUM,
    TELLURIUM,
    TERBIUM,
    THALLIUM,
    TIN,
    TITANIUM,
    TUNGSTEN,
    URANIUM,
    VANADIUM,
    YTTERBIUM,
    YTTRIUM,
    //ZINC,
    ZIRCONIUM;


    public static ArrayList<String> getMetals() {
        ArrayList<String> list = new ArrayList<>();
        for (MetallicEnum metal : MetallicEnum.values()) {
            list.add(metal.name().toLowerCase());
        }
        return list;
    }
}
