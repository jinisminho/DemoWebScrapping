/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import enums.CategoryEnums;

/**
 *
 * @author Hoang Pham
 */
public class Categorizer {

    public int getCategoryOfSignature(String signatureName) {
        int categoryId = -1;
        switch (signatureName.toLowerCase()) {
            case "bass-rolled neutral":
                categoryId = CategoryEnums.NEUTRAL.getCategoryId();
                break;
            case "bass-rolled warm":
                categoryId = CategoryEnums.WARM.getCategoryId();
                break;
            case "bassy":
                categoryId = CategoryEnums.DARK.getCategoryId();
                break;
            case "bright":
                categoryId = CategoryEnums.BRIGHT.getCategoryId();
                break;
            case "bright neutral":
                categoryId = CategoryEnums.ANALYTICAL.getCategoryId();
                break;
            case "neutral":
                categoryId = CategoryEnums.NEUTRAL.getCategoryId();
                break;
            case "neutral with bass boost":
                categoryId = CategoryEnums.WARM.getCategoryId();
                break;
            case "v-shaped":
                categoryId = CategoryEnums.FUN.getCategoryId();
                break;
            case "warm":
                categoryId = CategoryEnums.WARM.getCategoryId();
                break;
            case "warm v-shape":
                categoryId = CategoryEnums.DARK.getCategoryId();
                break;
            case "warm neutral":
                categoryId = CategoryEnums.WARM.getCategoryId();
                break;
            case "neutral with laid-back treble":
                categoryId = CategoryEnums.WARM.getCategoryId();
                break;
            case "u-shaped":
                categoryId = CategoryEnums.FUN.getCategoryId();
                break;
            case "unique":
                categoryId = CategoryEnums.BRIGHT.getCategoryId();
                break;
            case "upper mid focused":
                categoryId = CategoryEnums.MID.getCategoryId();
                break;
            case "variable":
                categoryId = CategoryEnums.FUN.getCategoryId();
                break;
            case "w-shaped":
                categoryId = CategoryEnums.FUN.getCategoryId();
                break;
            case "warm df-neutral":
                categoryId = CategoryEnums.NEUTRAL.getCategoryId();
                break;
            case "warm u-shape":
                categoryId = CategoryEnums.FUN.getCategoryId();
                break;
            case "bright df-neutral":
                categoryId = CategoryEnums.NEUTRAL.getCategoryId();
                break;
            case "bright u-shape":
                categoryId = CategoryEnums.FUN.getCategoryId();
                break;
            case "bright v-shape":
                categoryId = CategoryEnums.BRIGHT.getCategoryId();
                break;
            case "complete failure":
                categoryId = CategoryEnums.VERYBAD.getCategoryId();
                break;
            case "df-neutral":
                categoryId = CategoryEnums.NEUTRAL.getCategoryId();
                break;
            case "df-neutral with bass boost":
                categoryId = CategoryEnums.WARM.getCategoryId();
                break;
            case "dark neutral":
                categoryId = CategoryEnums.DARK.getCategoryId();
                break;
            case "extreme bass":
                categoryId = CategoryEnums.DARK.getCategoryId();
                break;
            case "extreme v-shape":
                categoryId = CategoryEnums.FUN.getCategoryId();
                break;
            case "harman-neutral":
                categoryId = CategoryEnums.NEUTRAL.getCategoryId();
                break;
            case "mid-centric":
                categoryId = CategoryEnums.MID.getCategoryId();
                break;
            case "mild u-shape":
                categoryId = CategoryEnums.FUN.getCategoryId();
                break;
            case "mild v-shape":
                categoryId = CategoryEnums.FUN.getCategoryId();
                break;
            case "\"balanced\"":
                categoryId = CategoryEnums.FUN.getCategoryId();
                break;
            case "dark":
                categoryId = CategoryEnums.DARK.getCategoryId();
                break;
            case "neutral-bright":
                categoryId = CategoryEnums.BRIGHT.getCategoryId();
                break;
        }
        return categoryId;
    }
}
