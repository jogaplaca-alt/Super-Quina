package E2;

import com.hoho.android.usbserial.driver.UsbId;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: renamed from: E2.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0201q extends Q {

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    private static final int[] f646U = {522, 568, 723, 809, 427, 919, 460, 155, 566, 861, 285, 19, 803, 17, 766, 76, 925, 537, 597, 784, 691, 437, 237, 308, 436, 284, 646, 653, 428, 379};

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    private static final int[] f647V = {27, 917, 522, 568, 723, 809, 237, 308, 436, 284, 646, 653, 428, 379, 274, 562, 232, 755, 599, 524, 801, 132, 295, 116, 442, 428, 295, 42, 176, 65, 361, 575, 922, 525, 176, 586, 640, 321, 536, 742, 677, 742, 687, 284, 193, 517, 273, 494, 263, 147, 593, 800, 571, 320, 803, 133, 231, 390, 685, 330, 63, 410, 539, 422, 6, 93, 862, 771, 453, 106, 610, 287, 107, 505, 733, 877, 381, 612, 723, 476, 462, 172, 430, 609, 858, 822, 543, 376, 511, 400, 672, 762, 283, 184, 440, 35, 519, 31, 460, 594, 225, 535, 517, 352, 605, 158, 651, 201, 488, 502, 648, 733, 717, 83, 404, 97, 280, 771, 840, 629, 4, 381, 843, 623, 264, 543, 521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, 400, 925, 749, 415, 822, 93, 217, 208, 928, 244, 583, 620, 246, 148, 447, 631, 292, 908, 490, 704, UsbId.ARM_MBED, 258, 457, 907, 594, 723, 674, 292, 272, 96, 684, 432, 686, 606, 860, 569, 193, 219, 129, 186, 236, 287, 192, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, 156, 732, 95, 270, 447, 90, 507, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, 262, 380, 602, 754, 336, 89, 614, 87, 432, 670, 616, 157, 374, 242, 726, 600, 269, 375, 898, 845, 454, 354, 130, 814, 587, 804, 34, 211, 330, 539, 297, 827, 865, 37, 517, 834, 315, 550, 86, 801, 4, 108, 539, 524, 894, 75, 766, 882, 857, 74, 204, 82, 586, 708, 250, 905, 786, 138, 720, 858, 194, 311, 913, 275, 190, 375, 850, 438, 733, 194, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, 204, 796, 605, 540, 913, 801, 700, 799, 137, 439, 418, 592, 668, 353, 859, 370, 694, 325, 240, 216, 257, 284, 549, 209, 884, 315, 70, 329, 793, 490, 274, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, 307, 291, 803, 712, 19, 358, 399, 908, 103, 511, 51, 8, 517, 225, 289, 470, 637, 731, 66, 255, 917, 269, 463, 830, 730, 433, 848, 585, 136, 538, 906, 90, 2, 290, 743, 199, 655, 903, 329, 49, 802, 580, 355, 588, 188, 462, 10, 134, 628, 320, 479, 130, 739, 71, 263, 318, 374, 601, 192, 605, 142, 673, 687, 234, 722, 384, 177, 752, 607, 640, 455, 193, 689, 707, 805, 641, 48, 60, 732, 621, 895, 544, 261, 852, 655, 309, 697, 755, 756, 60, 231, 773, 434, 421, 726, 528, 503, 118, 49, 795, 32, 144, 500, 238, 836, 394, 280, 566, 319, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, 609, 441, 180, 791, 893, 754, 605, 383, 228, 749, 760, 213, 54, 297, 134, 54, 834, 299, 922, 191, 910, 532, 609, 829, 189, 20, 167, 29, 872, 449, 83, 402, 41, 656, 505, 579, 481, 173, 404, 251, 688, 95, 497, 555, 642, 543, 307, 159, 924, 558, 648, 55, 497, 10, 352, 77, 373, 504, 35, 599, 428, 207, 409, 574, 118, 498, 285, 380, 350, 492, 197, 265, 920, 155, 914, 299, 229, 643, 294, 871, 306, 88, 87, 193, 352, 781, 846, 75, 327, 520, 435, 543, 203, 666, 249, 346, 781, 621, 640, 268, 794, 534, 539, 781, 408, 390, 644, 102, 476, 499, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, 272, 383, 800, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, 290, 204, 681, 407, 855, 85, 99, 62, 482, 180, 20, 297, 451, 593, 913, 142, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, 513, 192, UsbId.ARM_MBED, 258, 240, 518, 794, 395, 768, 848, 51, 610, 384, 168, 190, 826, 328, 596, 786, 303, 570, 381, 415, 641, 156, 237, 151, 429, 531, 207, 676, 710, 89, 168, 304, 402, 40, 708, 575, 162, 864, 229, 65, 861, 841, 512, 164, 477, 221, 92, 358, 785, 288, 357, 850, 836, 827, 736, 707, 94, 8, 494, 114, 521, 2, 499, 851, 543, 152, 729, 771, 95, 248, 361, 578, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, 902, 452, 167, 342, 244, 173, 35, 463, 651, 51, 699, 591, 452, 578, 37, 124, 298, 332, 552, 43, 427, 119, 662, 777, 475, 850, 764, 364, 578, 911, 283, 711, 472, 420, 245, 288, 594, 394, 511, 327, 589, 777, 699, 688, 43, 408, 842, 383, 721, 521, 560, 644, 714, 559, 62, 145, 873, 663, 713, 159, 672, 729, 624, 59, 193, 417, 158, 209, 563, 564, 343, 693, 109, 608, 563, 365, 181, 772, 677, 310, 248, 353, 708, 410, 579, 870, 617, 841, 632, 860, 289, 536, 35, 777, 618, 586, 424, 833, 77, 597, 346, 269, 757, 632, 695, 751, 331, 247, 184, 45, 787, 680, 18, 66, 407, 369, 54, 492, 228, 613, 830, 922, 437, 519, 644, 905, 789, 420, 305, 441, 207, 300, 892, 827, 141, 537, 381, 662, 513, 56, 252, 341, 242, 797, 838, 837, 720, 224, 307, 631, 61, 87, 560, 310, 756, 665, 397, 808, 851, 309, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, 425, 216, 548, 249, 321, 881, 699, 535, 673, 782, 210, 815, 905, 303, 843, 922, 281, 73, 469, 791, 660, 162, 498, 308, 155, 422, 907, 817, 187, 62, 16, 425, 535, 336, 286, 437, 375, 273, 610, 296, 183, 923, 116, 667, 751, 353, 62, 366, 691, 379, 687, 842, 37, 357, 720, 742, 330, 5, 39, 923, 311, 424, 242, 749, 321, 54, 669, 316, 342, 299, 534, 105, 667, 488, 640, 672, 576, 540, 316, 486, 721, 610, 46, 656, 447, 171, 616, 464, 190, 531, 297, 321, 762, 752, 533, 175, 134, 14, 381, 433, 717, 45, 111, 20, 596, 284, 736, 138, 646, 411, 877, 669, 141, 919, 45, 780, 407, 164, 332, 899, 165, 726, 600, 325, 498, 655, 
    357, 752, 768, 223, 849, 647, 63, 310, 863, 251, 366, 304, 282, 738, 675, 410, 389, 244, 31, 121, 303, 263};

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    private static final int[] f648W = {5, 6, 7, 8, 9, 10, 12, 4, 5, 6, 7, 8, 3, 4, 5, 6, 7, 4, 4, 5, 5, 6, 6, 7, 4, 5, 6, 7, 7, 4, 5, 6, 7, 8, 0, 0, 4, 4, 9, 9, 15, 0, 4, 9, 15, 15, 0, 4, 9, 15, 22};

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    private static final int[] f649X = {39, 1, 32, 8, 14, 43, 20, 11, 1, 5, 15, 21, 40, 43, 46, 34, 29, 0, 0, 0, 0, 0, 0, 0, 43, 33, 37, 47, 1, 20, 23, 26, 14, 9, 19, 33, 12, 40, 46, 23, 52, 23, 13, 17, 27, 33, 52, 3, 6, 46, 41, 6, 0, 3, 3, 3, 0, 3, 3, 0, 3, 6, 6, 0, 0, 0, 0, 3};

    /* JADX INFO: renamed from: Y, reason: collision with root package name */
    private static final String[] f650Y = {"urA", "xfs", "ypy", "unk", "xdw", "yoz", "pDA", "uls", "pBk", "eBA", "pAs", "eAk", "prA", "uvs", "xhy", "pnk", "utw", "xgz", "fDA", "pls", "fBk", "frA", "pvs", "uxy", "fnk", "ptw", "uwz", "fls", "psy", "fvs", "pxy", "ftw", "pwz", "fxy", "yrx", "ufk", "xFw", "ymz", "onA", "uds", "xEy", "olk", "ucw", "dBA", "oks", "uci", "dAk", "okg", "dAc", "ovk", "uhw", "xaz", "dnA", "ots", "ugy", "dlk", "osw", "ugj", "dks", "osi", "dvk", "oxw", "uiz", "dts", "owy", "dsw", "owj", "dxw", "oyz", "dwy", "dwj", "ofA", "uFs", "xCy", "odk", "uEw", "xCj", "clA", "ocs", "uEi", "ckk", "ocg", "ckc", "ckE", "cvA", "ohs", "uay", "ctk", "ogw", "uaj", "css", "ogi", "csg", "csa", "cxs", "oiy", "cww", "oij", "cwi", "cyy", "oFk", "uCw", "xBj", "cdA", "oEs", "uCi", "cck", "oEg", "uCb", "ccc", "oEa", "ccE", "oED", "chk", "oaw", "uDj", "cgs", "oai", "cgg", "oab", "cga", "cgD", "obj", "cib", "cFA", "oCs", "uBi", "cEk", "oCg", "uBb", "cEc", "oCa", "cEE", "oCD", "cEC", "cas", "cag", "caa", "cCk", "uAr", "oBa", "oBD", "cCB", "tfk", "wpw", "yez", "mnA", "tds", "woy", "mlk", "tcw", "woj", "FBA", "mks", "FAk", "mvk", "thw", "wqz", "FnA", "mts", "tgy", "Flk", "msw", "Fks", "Fkg", "Fvk", "mxw", "tiz", "Fts", "mwy", "Fsw", "Fsi", "Fxw", "myz", "Fwy", "Fyz", "vfA", "xps", "yuy", "vdk", "xow", "yuj", "qlA", "vcs", "xoi", "qkk", "vcg", "xob", "qkc", "vca", "mfA", "tFs", "wmy", "qvA", "mdk", "tEw", "wmj", "qtk", "vgw", "xqj", "hlA", "Ekk", "mcg", "tEb", "hkk", "qsg", "hkc", "EvA", "mhs", "tay", "hvA", "Etk", "mgw", "taj", "htk", "qww", "vij", "hss", "Esg", "hsg", "Exs", "miy", "hxs", "Eww", "mij", "hww", "qyj", "hwi", "Eyy", "hyy", "Eyj", "hyj", "vFk", "xmw", "ytj", "qdA", "vEs", "xmi", "qck", "vEg", "xmb", "qcc", "vEa", "qcE", "qcC", "mFk", "tCw", "wlj", "qhk", "mEs", "tCi", "gtA", "Eck", "vai", "tCb", "gsk", "Ecc", "mEa", "gsc", "qga", "mED", "EcC", "Ehk", "maw", "tDj", "gxk", "Egs", "mai", "gws", "qii", "mab", "gwg", "Ega", "EgD", "Eiw", "mbj", "gyw", "Eii", "gyi", "Eib", "gyb", "gzj", "qFA", "vCs", "xli", "qEk", "vCg", "xlb", "qEc", "vCa", "qEE", "vCD", "qEC", "qEB", "EFA", "mCs", "tBi", "ghA", "EEk", "mCg", "tBb", "ggk", "qag", "vDb", "ggc", "EEE", "mCD", "ggE", "qaD", "ggC", "Eas", "mDi", "gis", "Eag", "mDb", "gig", "qbb", "gia", "EaD", "giD", "gji", "gjb", "qCk", "vBg", "xkr", "qCc", "vBa", "qCE", "vBD", "qCC", "qCB", "ECk", "mBg", "tAr", "gak", "ECc", "mBa", "gac", "qDa", "mBD", "gaE", "ECC", "gaC", "ECB", "EDg", "gbg", "gba", "gbD", "vAq", "vAn", "qBB", "mAq", "EBE", "gDE", "gDC", "gDB", "lfA", "sps", "wey", "ldk", "sow", "ClA", "lcs", "soi", "Ckk", "lcg", "Ckc", "CkE", "CvA", "lhs", "sqy", "Ctk", "lgw", "sqj", "Css", "lgi", "Csg", "Csa", "Cxs", "liy", "Cww", "lij", "Cwi", "Cyy", "Cyj", "tpk", "wuw", "yhj", "ndA", "tos", "wui", "nck", "tog", "wub", "ncc", "toa", "ncE", "toD", "lFk", "smw", "wdj", "nhk", "lEs", "smi", "atA", "Cck", "tqi", "smb", "ask", "ngg", "lEa", "asc", "CcE", "asE", "Chk", "law", "snj", "axk", "Cgs", "trj", "aws", "nii", "lab", "awg", "Cga", "awa", "Ciw", "lbj", "ayw", "Cii", "ayi", "Cib", "Cjj", "azj", "vpA", "xus", "yxi", "vok", "xug", "yxb", "voc", "xua", "voE", "xuD", "voC", "nFA", "tms", "wti", "rhA", "nEk", "xvi", "wtb", "rgk", "vqg", "xvb", "rgc", "nEE", "tmD", "rgE", "vqD", "nEB", "CFA", "lCs", "sli", "ahA", "CEk", "lCg", "slb", "ixA", "agk", "nag", "tnb", "iwk", "rig", "vrb", "lCD", "iwc", "agE", "naD", "iwE", "CEB", "Cas", "lDi", "ais", "Cag", "lDb", "iys", "aig", "nbb", "iyg", "rjb", "CaD", "aiD", "Cbi", "aji", "Cbb", "izi", "ajb", "vmk", "xtg", "ywr", "vmc", "xta", "vmE", "xtD", "vmC", "vmB", "nCk", "tlg", "wsr", "rak", "nCc", "xtr", "rac", "vna", "tlD", "raE", "nCC", "raC", "nCB", "raB", "CCk", "lBg", "skr", "aak", "CCc", "lBa", "iik", "aac", "nDa", "lBD", "iic", "rba", "CCC", "iiE", "aaC", "CCB", "aaB", "CDg", "lBr", "abg", "CDa", "ijg", "aba", "CDD", "ija", "abD", "CDr", "ijr", "vlc", "xsq", "vlE", "xsn", "vlC", "vlB", "nBc", "tkq", "rDc", "nBE", "tkn", "rDE", "vln", "rDC", "nBB", "rDB", "CBc", "lAq", "aDc", "CBE", "lAn", "ibc", "aDE", "nBn", "ibE", "rDn", "CBB", "ibC", "aDB", "ibB", "aDq", "ibq", "ibn", "xsf", "vkl", "tkf", "nAm", "nAl", "CAo", "aBo", "iDo", "CAl", "aBl", "kpk", "BdA", "kos", "Bck", "kog", "seb", "Bcc", "koa", "BcE", "koD", "Bhk", "kqw", "sfj", "Bgs", "kqi", "Bgg", "kqb", "Bga", "BgD", "Biw", "krj", "Bii", "Bib", "Bjj", "lpA", "sus", "whi", "lok", "sug", "loc", "sua", "loE", "suD", "loC", "BFA", "kms", "sdi", "DhA", "BEk", "svi", "sdb", "Dgk", "lqg", "svb", "Dgc", "BEE", "kmD", "DgE", "lqD", "BEB", "Bas", "kni", "Dis", "Bag", "knb", "Dig", "lrb", "Dia", "BaD", "Bbi", "Dji", "Bbb", "Djb", "tuk", "wxg", "yir", "tuc", "wxa", "tuE", "wxD", "tuC", "tuB", "lmk", "stg", "nqk", "lmc", "sta", "nqc", "tva", "stD", "nqE", "lmC", "nqC", "lmB", "nqB", "BCk", "klg", "Dak", "BCc", "str", "bik", "Dac", "lna", "klD", "bic", "nra", "BCC", "biE", "DaC", "BCB", "DaB", "BDg", "klr", "Dbg", "BDa", "bjg", "Dba", "BDD", "bja", "DbD", "BDr", "Dbr", "bjr", "xxc", "yyq", "xxE", "yyn", "xxC", "xxB", "ttc", "wwq", "vvc", "xxq", "wwn", "vvE", "xxn", "vvC", "ttB", "vvB", "llc", "ssq", "nnc", "llE", "ssn", "rrc", "nnE", "ttn", "rrE", "vvn", "llB", "rrC", "nnB", "rrB", "BBc", "kkq", "DDc", "BBE", "kkn", "bbc", "DDE", "lln", "jjc", "bbE", "nnn", "BBB", "jjE", "rrn", "DDB", "jjC", "BBq", "DDq", "BBn", "bbq", "DDn", "jjq", "bbn", "jjn", "xwo", "yyf", "xwm", "xwl", "tso", "wwf", "vto", "xwv", "vtm", "tsl", "vtl", "lko", "ssf", "nlo", "lkm", "rno", "nlm", "lkl", "rnm", "nll", "rnl", "BAo", "kkf", "DBo", "lkv", "bDo", "DBm", "BAl", "jbo", "bDm", "DBl", "jbm", "bDl", "jbl", "DBv", "jbv", "xwd", "vsu", "vst", "nku", "rlu", "rlt", "DAu", "bBu", "jDu", "jDt", "ApA", "Aok", "keg", "Aoc", "AoE", "AoC", "Aqs", "Aqg", "Aqa", "AqD", "Ari", "Arb", "kuk", "kuc", "sha", "kuE", "shD", "kuC", "kuB", "Amk", "kdg", "Bqk", "kvg", "kda", "Bqc", "kva", "BqE", "kvD", "BqC", "AmB", "BqB", "Ang", "kdr", "Brg", "kvr", "Bra", "AnD", "BrD", "Anr", "Brr", "sxc", "sxE", "sxC", "sxB", "ktc", "lvc", "sxq", "sgn", "lvE", "sxn", "lvC", "ktB", "lvB", "Alc", "Bnc", "AlE", "kcn", "Drc", "BnE", "AlC", "DrE", "BnC", "AlB", "DrC", "BnB", "Alq", "Bnq", "Aln", "Drq", "Bnn", "Drn", "wyo", "wym", "wyl", "swo", "txo", "wyv", "txm", "swl", "txl", "kso", "sgf", "lto", "swv", "nvo", "ltm", "ksl", "nvm", "ltl", "nvl", "Ako", "kcf", "Blo", "ksv", "Dno", "Blm", "Akl", "bro", "Dnm", "Bll", "brm", "Dnl", "Akv", "Blv", "Dnv", "brv", "yze", "yzd", "wye", "xyu", "wyd", "xyt", "swe", "twu", "swd", "vxu", "twt", "vxt", "kse", "lsu", "ksd", "ntu", "lst", "rvu", "ypk", "zew", "xdA", "yos", "zei", "xck", "yog", "zeb", "xcc", "yoa", "xcE", "yoD", "xcC", "xhk", "yqw", "zfj", "utA", "xgs", "yqi", "usk", "xgg", "yqb", "usc", "xga", "usE", "xgD", "usC", "uxk", "xiw", "yrj", "ptA", "uws", "xii", "psk", "uwg", "xib", "psc", "uwa", "psE", "uwD", "psC", "pxk", "uyw", "xjj", "ftA", "pws", "uyi", "fsk", "pwg", "uyb", "fsc", "pwa", "fsE", "pwD", "fxk", "pyw", "uzj", "fws", "pyi", "fwg", "pyb", "fwa", "fyw", "pzj", "fyi", "fyb", "xFA", "yms", "zdi", "xEk", "ymg", 
    "zdb", "xEc", "yma", "xEE", "ymD", "xEC", "xEB", "uhA", "xas", "yni", "ugk", "xag", "ynb", "ugc", "xaa", "ugE", "xaD", "ugC", "ugB", "oxA", "uis", "xbi", "owk", "uig", "xbb", "owc", "uia", "owE", "uiD", "owC", "owB", "dxA", "oys", "uji", "dwk", "oyg", "ujb", "dwc", "oya", "dwE", "oyD", "dwC", "dys", "ozi", "dyg", "ozb", "dya", "dyD", "dzi", "dzb", "xCk", "ylg", "zcr", "xCc", "yla", "xCE", "ylD", "xCC", "xCB", "uak", "xDg", "ylr", "uac", "xDa", "uaE", "xDD", "uaC", "uaB", "oik", "ubg", "xDr", "oic", "uba", "oiE", "ubD", "oiC", "oiB", "cyk", "ojg", "ubr", "cyc", "oja", "cyE", "ojD", "cyC", "cyB", "czg", "ojr", "cza", "czD", "czr", "xBc", "ykq", "xBE", "ykn", "xBC", "xBB", "uDc", "xBq", "uDE", "xBn", "uDC", "uDB", "obc", "uDq", "obE", "uDn", "obC", "obB", "cjc", "obq", "cjE", "obn", "cjC", "cjB", "cjq", "cjn", "xAo", "ykf", "xAm", "xAl", "uBo", "xAv", "uBm", "uBl", "oDo", "uBv", "oDm", "oDl", "cbo", "oDv", "cbm", "cbl", "xAe", "xAd", "uAu", "uAt", "oBu", "oBt", "wpA", "yes", "zFi", "wok", "yeg", "zFb", "woc", "yea", "woE", "yeD", "woC", "woB", "thA", "wqs", "yfi", "tgk", "wqg", "yfb", "tgc", "wqa", "tgE", "wqD", "tgC", "tgB", "mxA", "tis", "wri", "mwk", "tig", "wrb", "mwc", "tia", "mwE", "tiD", "mwC", "mwB", "FxA", "mys", "tji", "Fwk", "myg", "tjb", "Fwc", "mya", "FwE", "myD", "FwC", "Fys", "mzi", "Fyg", "mzb", "Fya", "FyD", "Fzi", "Fzb", "yuk", "zhg", "hjs", "yuc", "zha", "hbw", "yuE", "zhD", "hDy", "yuC", "yuB", "wmk", "ydg", "zEr", "xqk", "wmc", "zhr", "xqc", "yva", "ydD", "xqE", "wmC", "xqC", "wmB", "xqB", "tak", "wng", "ydr", "vik", "tac", "wna", "vic", "xra", "wnD", "viE", "taC", "viC", "taB", "viB", "mik", "tbg", "wnr", "qyk", "mic", "tba", "qyc", "vja", "tbD", "qyE", "miC", "qyC", "miB", "qyB", "Eyk", "mjg", "tbr", "hyk", "Eyc", "mja", "hyc", "qza", "mjD", "hyE", "EyC", "hyC", "EyB", "Ezg", "mjr", "hzg", "Eza", "hza", "EzD", "hzD", "Ezr", "ytc", "zgq", "grw", "ytE", "zgn", "gny", "ytC", "glz", "ytB", "wlc", "ycq", "xnc", "wlE", "ycn", "xnE", "ytn", "xnC", "wlB", "xnB", "tDc", "wlq", "vbc", "tDE", "wln", "vbE", "xnn", "vbC", "tDB", "vbB", "mbc", "tDq", "qjc", "mbE", "tDn", "qjE", "vbn", "qjC", "mbB", "qjB", "Ejc", "mbq", "gzc", "EjE", "mbn", "gzE", "qjn", "gzC", "EjB", "gzB", "Ejq", "gzq", "Ejn", "gzn", "yso", "zgf", "gfy", "ysm", "gdz", "ysl", "wko", "ycf", "xlo", "ysv", "xlm", "wkl", "xll", "tBo", "wkv", "vDo", "tBm", "vDm", "tBl", "vDl", "mDo", "tBv", "qbo", "vDv", "qbm", "mDl", "qbl", "Ebo", "mDv", "gjo", "Ebm", "gjm", "Ebl", "gjl", "Ebv", "gjv", "yse", "gFz", "ysd", "wke", "xku", "wkd", "xkt", "tAu", "vBu", "tAt", "vBt", "mBu", "qDu", "mBt", "qDt", "EDu", "gbu", "EDt", "gbt", "ysF", "wkF", "xkh", "tAh", "vAx", "mAx", "qBx", "wek", "yFg", "zCr", "wec", "yFa", "weE", "yFD", "weC", "weB", "sqk", "wfg", "yFr", "sqc", "wfa", "sqE", "wfD", "sqC", "sqB", "lik", "srg", "wfr", "lic", "sra", "liE", "srD", "liC", "liB", "Cyk", "ljg", "srr", "Cyc", "lja", "CyE", "ljD", "CyC", "CyB", "Czg", "ljr", "Cza", "CzD", "Czr", "yhc", "zaq", "arw", "yhE", "zan", "any", "yhC", "alz", "yhB", "wdc", "yEq", "wvc", "wdE", "yEn", "wvE", "yhn", "wvC", "wdB", "wvB", "snc", "wdq", "trc", "snE", "wdn", "trE", "wvn", "trC", "snB", "trB", "lbc", "snq", "njc", "lbE", "snn", "njE", "trn", "njC", "lbB", "njB", "Cjc", "lbq", "azc", "CjE", "lbn", "azE", "njn", "azC", "CjB", "azB", "Cjq", "azq", "Cjn", "azn", "zio", "irs", "rfy", "zim", "inw", "rdz", "zil", "ily", "ikz", "ygo", "zaf", "afy", "yxo", "ziv", "ivy", "adz", "yxm", "ygl", "itz", "yxl", "wco", "yEf", "wto", "wcm", "xvo", "yxv", "wcl", "xvm", "wtl", "xvl", "slo", "wcv", "tno", "slm", "vro", "tnm", "sll", "vrm", "tnl", "vrl", "lDo", "slv", "nbo", "lDm", "rjo", "nbm", "lDl", "rjm", "nbl", "rjl", "Cbo", "lDv", "ajo", "Cbm", "izo", "ajm", "Cbl", "izm", "ajl", "izl", "Cbv", "ajv", "zie", "ifw", "rFz", "zid", "idy", "icz", "yge", "aFz", "ywu", "ygd", "ihz", "ywt", "wce", "wsu", "wcd", "xtu", "wst", "xtt", "sku", "tlu", "skt", "vnu", "tlt", "vnt", "lBu", "nDu", "lBt", "rbu", "nDt", "rbt", "CDu", "abu", "CDt", "iju", "abt", "ijt", "ziF", "iFy", "iEz", "ygF", "ywh", "wcF", "wsh", "xsx", "skh", "tkx", "vlx", "lAx", "nBx", "rDx", "CBx", "aDx", "ibx", "iCz", "wFc", "yCq", "wFE", "yCn", "wFC", "wFB", "sfc", "wFq", "sfE", "wFn", "sfC", "sfB", "krc", "sfq", "krE", "sfn", "krC", "krB", "Bjc", "krq", "BjE", "krn", "BjC", "BjB", "Bjq", "Bjn", "yao", "zDf", "Dfy", "yam", "Ddz", "yal", "wEo", "yCf", "who", "wEm", "whm", "wEl", "whl", "sdo", "wEv", "svo", "sdm", "svm", "sdl", "svl", "kno", "sdv", "lro", "knm", "lrm", "knl", "lrl", "Bbo", "knv", "Djo", "Bbm", "Djm", "Bbl", "Djl", "Bbv", "Djv", "zbe", "bfw", "npz", "zbd", "bdy", "bcz", "yae", "DFz", "yiu", "yad", "bhz", "yit", "wEe", "wgu", "wEd", "wxu", "wgt", "wxt", "scu", "stu", "sct", "tvu", "stt", "tvt", "klu", "lnu", "klt", "nru", "lnt", "nrt", "BDu", "Dbu", "BDt", "bju", "Dbt", "bjt", "jfs", "rpy", "jdw", "roz", "jcy", "jcj", "zbF", "bFy", "zjh", "jhy", "bEz", "jgz", "yaF", "yih", "yyx", "wEF", "wgh", "wwx", "xxx", "sch", "ssx", "ttx", "vvx", "kkx", "llx", "nnx", "rrx", "BBx", "DDx", "bbx", "jFw", "rmz", "jEy", "jEj", "bCz", "jaz", "jCy", "jCj", "jBj", "wCo", "wCm", "wCl", "sFo", "wCv", "sFm", "sFl", "kfo", "sFv", "kfm", "kfl", "Aro", "kfv", "Arm", "Arl", "Arv", "yDe", "Bpz", "yDd", "wCe", "wau", "wCd", "wat", "sEu", "shu", "sEt", "sht", "kdu", "kvu", "kdt", "kvt", "Anu", "Bru", "Ant", "Brt", "zDp", "Dpy", "Doz", "yDF", "ybh", "wCF", "wah", "wix", "sEh", "sgx", "sxx", "kcx", "ktx", "lvx", "Alx", "Bnx", "Drx", "bpw", "nuz", "boy", "boj", "Dmz", "bqz", "jps", "ruy", "jow", "ruj", "joi", "job", "bmy", "jqy", "bmj", "jqj", "jmw", "rtj", "jmi", "jmb", "blj", "jnj", "jli", "jlb", "jkr", "sCu", "sCt", "kFu", "kFt", "Afu", "Aft", "wDh", "sCh", "sax", "kEx", "khx", "Adx", "Avx", "Buz", "Duy", "Duj", "buw", "nxj", "bui", "bub", "Dtj", "bvj", "jus", "rxi", "jug", "rxb", "jua", "juD", "bti", "jvi", "btb", "jvb", "jtg", "rwr", "jta", "jtD", "bsr", "jtr", "jsq", "jsn", "Bxj", "Dxi", "Dxb", "bxg", "nyr", "bxa", "bxD", "Dwr", "bxr", "bwq", "bwn", "pjk", "urw", "ejA", "pbs", "uny", "ebk", "pDw", "ulz", "eDs", "pBy", "eBw", "zfc", "fjk", "prw", "zfE", "fbs", "pny", "zfC", "fDw", "plz", "zfB", "fBy", "yrc", "zfq", "frw", "yrE", "zfn", "fny", "yrC", "flz", "yrB", "xjc", "yrq", "xjE", "yrn", "xjC", "xjB", "uzc", "xjq", "uzE", "xjn", "uzC", "uzB", "pzc", "uzq", "pzE", "uzn", "pzC", "djA", "ors", "ufy", "dbk", "onw", "udz", "dDs", "oly", "dBw", "okz", "dAy", "zdo", "drs", "ovy", "zdm", "dnw", "otz", "zdl", "dly", "dkz", "yno", "zdv", "dvy", "ynm", "dtz", "ynl", "xbo", "ynv", "xbm", "xbl", "ujo", "xbv", "ujm", "ujl", "ozo", "ujv", "ozm", "ozl", "crk", "ofw", "uFz", "cns", "ody", "clw", "ocz", "cky", "ckj", "zcu", "cvw", "ohz", "zct", "cty", "csz", "ylu", "cxz", "ylt", "xDu", "xDt", "ubu", "ubt", "oju", "ojt", "cfs", "oFy", "cdw", "oEz", "ccy", "ccj", "zch", "chy", "cgz", "ykx", "xBx", "uDx", "cFw", "oCz", "cEy", "cEj", "caz", "cCy", "cCj", "FjA", "mrs", "tfy", "Fbk", "mnw", "tdz", "FDs", "mly", "FBw", "mkz", "FAy", "zFo", "Frs", 
    "mvy", "zFm", "Fnw", "mtz", "zFl", "Fly", "Fkz", "yfo", "zFv", "Fvy", "yfm", "Ftz", "yfl", "wro", "yfv", "wrm", "wrl", "tjo", "wrv", "tjm", "tjl", "mzo", "tjv", "mzm", "mzl", "qrk", "vfw", "xpz", "hbA", "qns", "vdy", "hDk", "qlw", "vcz", "hBs", "qky", "hAw", "qkj", "hAi", "Erk", "mfw", "tFz", "hrk", "Ens", "mdy", "hns", "qty", "mcz", "hlw", "Eky", "hky", "Ekj", "hkj", "zEu", "Evw", "mhz", "zhu", "zEt", "hvw", "Ety", "zht", "hty", "Esz", "hsz", "ydu", "Exz", "yvu", "ydt", "hxz", "yvt", "wnu", "xru", "wnt", "xrt", "tbu", "vju", "tbt", "vjt", "mju", "mjt", "grA", "qfs", "vFy", "gnk", "qdw", "vEz", "gls", "qcy", "gkw", "qcj", "gki", "gkb", "Efs", "mFy", "gvs", "Edw", "mEz", "gtw", "qgz", "gsy", "Ecj", "gsj", "zEh", "Ehy", "zgx", "gxy", "Egz", "gwz", "ycx", "ytx", "wlx", "xnx", "tDx", "vbx", "mbx", "gfk", "qFw", "vCz", "gds", "qEy", "gcw", "qEj", "gci", "gcb", "EFw", "mCz", "ghw", "EEy", "ggy", "EEj", "ggj", "Eaz", "giz", "gFs", "qCy", "gEw", "qCj", "gEi", "gEb", "ECy", "gay", "ECj", "gaj", "gCw", "qBj", "gCi", "gCb", "EBj", "gDj", "gBi", "gBb", "Crk", "lfw", "spz", "Cns", "ldy", "Clw", "lcz", "Cky", "Ckj", "zCu", "Cvw", "lhz", "zCt", "Cty", "Csz", "yFu", "Cxz", "yFt", "wfu", "wft", "sru", "srt", "lju", "ljt", "arA", "nfs", "tpy", "ank", "ndw", "toz", "als", "ncy", "akw", "ncj", "aki", "akb", "Cfs", "lFy", "avs", "Cdw", "lEz", "atw", "ngz", "asy", "Ccj", "asj", "zCh", "Chy", "zax", "axy", "Cgz", "awz", "yEx", "yhx", "wdx", "wvx", "snx", "trx", "lbx", "rfk", "vpw", "xuz", "inA", "rds", "voy", "ilk", "rcw", "voj", "iks", "rci", "ikg", "rcb", "ika", "afk", "nFw", "tmz", "ivk", "ads", "nEy", "its", "rgy", "nEj", "isw", "aci", "isi", "acb", "isb", "CFw", "lCz", "ahw", "CEy", "ixw", "agy", "CEj", "iwy", "agj", "iwj", "Caz", "aiz", "iyz", "ifA", "rFs", "vmy", "idk", "rEw", "vmj", "ics", "rEi", "icg", "rEb", "ica", "icD", "aFs", "nCy", "ihs", "aEw", "nCj", "igw", "raj", "igi", "aEb", "igb", "CCy", "aay", "CCj", "iiy", "aaj", "iij", "iFk", "rCw", "vlj", "iEs", "rCi", "iEg", "rCb", "iEa", "iED", "aCw", "nBj", "iaw", "aCi", "iai", "aCb", "iab", "CBj", "aDj", "ibj", "iCs", "rBi", "iCg", "rBb", "iCa", "iCD", "aBi", "iDi", "aBb", "iDb", "iBg", "rAr", "iBa", "iBD", "aAr", "iBr", "iAq", "iAn", "Bfs", "kpy", "Bdw", "koz", "Bcy", "Bcj", "Bhy", "Bgz", "yCx", "wFx", "sfx", "krx", "Dfk", "lpw", "suz", "Dds", "loy", "Dcw", "loj", "Dci", "Dcb", "BFw", "kmz", "Dhw", "BEy", "Dgy", "BEj", "Dgj", "Baz", "Diz", "bfA", "nps", "tuy", "bdk", "now", "tuj", "bcs", "noi", "bcg", "nob", "bca", "bcD", "DFs", "lmy", "bhs", "DEw", "lmj", "bgw", "DEi", "bgi", "DEb", "bgb", "BCy", "Day", "BCj", "biy", "Daj", "bij", "rpk", "vuw", "xxj", "jdA", "ros", "vui", "jck", "rog", "vub", "jcc", "roa", "jcE", "roD", "jcC", "bFk", "nmw", "ttj", "jhk", "bEs", "nmi", "jgs", "rqi", "nmb", "jgg", "bEa", "jga", "bED", "jgD", "DCw", "llj", "baw", "DCi", "jiw", "bai", "DCb", "jii", "bab", "jib", "BBj", "DDj", "bbj", "jjj", "jFA", "rms", "vti", "jEk", "rmg", "vtb", "jEc", "rma", "jEE", "rmD", "jEC", "jEB", "bCs", "nli", "jas", "bCg", "nlb", "jag", "rnb", "jaa", "bCD", "jaD", "DBi", "bDi", "DBb", "jbi", "bDb", "jbb", "jCk", "rlg", "vsr", "jCc", "rla", "jCE", "rlD", "jCC", "jCB", "bBg", "nkr", "jDg", "bBa", "jDa", "bBD", "jDD", "DAr", "bBr", "jDr", "jBc", "rkq", "jBE", "rkn", "jBC", "jBB", "bAq", "jBq", "bAn", "jBn", "jAo", "rkf", "jAm", "jAl", "bAf", "jAv", "Apw", "kez", "Aoy", "Aoj", "Aqz", "Bps", "kuy", "Bow", "kuj", "Boi", "Bob", "Amy", "Bqy", "Amj", "Bqj", "Dpk", "luw", "sxj", "Dos", "lui", "Dog", "lub", "Doa", "DoD", "Bmw", "ktj", "Dqw", "Bmi", "Dqi", "Bmb", "Dqb", "Alj", "Bnj", "Drj", "bpA", "nus", "txi", "bok", "nug", "txb", "boc", "nua", "boE", "nuD", "boC", "boB", "Dms", "lti", "bqs", "Dmg", "ltb", "bqg", "nvb", "bqa", "DmD", "bqD", "Bli", "Dni", "Blb", "bri", "Dnb", "brb", "ruk", "vxg", "xyr", "ruc", "vxa", "ruE", "vxD", "ruC", "ruB", "bmk", "ntg", "twr", "jqk", "bmc", "nta", "jqc", "rva", "ntD", "jqE", "bmC", "jqC", "bmB", "jqB", "Dlg", "lsr", "bng", "Dla", "jrg", "bna", "DlD", "jra", "bnD", "jrD", "Bkr", "Dlr", "bnr", "jrr", "rtc", "vwq", "rtE", "vwn", "rtC", "rtB", "blc", "nsq", "jnc", "blE", "nsn", "jnE", "rtn", "jnC", "blB", "jnB", "Dkq", "blq", "Dkn", "jnq", "bln", "jnn", "rso", "vwf", "rsm", "rsl", "bko", "nsf", "jlo", "bkm", "jlm", "bkl", "jll", "Dkf", "bkv", "jlv", "rse", "rsd", "bke", "jku", "bkd", "jkt", "Aey", "Aej", "Auw", "khj", "Aui", "Aub", "Adj", "Avj", "Bus", "kxi", "Bug", "kxb", "Bua", "BuD", "Ati", "Bvi", "Atb", "Bvb", "Duk", "lxg", "syr", "Duc", "lxa", "DuE", "lxD", "DuC", "DuB", "Btg", "kwr", "Dvg", "lxr", "Dva", "BtD", "DvD", "Asr", "Btr", "Dvr", "nxc", "tyq", "nxE", "tyn", "nxC", "nxB", "Dtc", "lwq", "bvc", "nxq", "lwn", "bvE", "DtC", "bvC", "DtB", "bvB", "Bsq", "Dtq", "Bsn", "bvq", "Dtn", "bvn", "vyo", "xzf", "vym", "vyl", "nwo", "tyf", "rxo", "nwm", "rxm", "nwl", "rxl", "Dso", "lwf", "bto", "Dsm", "jvo", "btm", "Dsl", "jvm", "btl", "jvl", "Bsf", "Dsv", "btv", "jvv", "vye", "vyd", "nwe", "rwu", "nwd", "rwt", "Dse", "bsu", "Dsd", "jtu", "bst", "jtt", "vyF", "nwF", "rwh", "DsF", "bsh", "jsx", "Ahi", "Ahb", "Axg", "kir", "Axa", "AxD", "Agr", "Axr", "Bxc", "kyq", "BxE", "kyn", "BxC", "BxB", "Awq", "Bxq", "Awn", "Bxn", "lyo", "szf", "lym", "lyl", "Bwo", "kyf", "Dxo", "lyv", "Dxm", "Bwl", "Dxl", "Awf", "Bwv", "Dxv", "tze", "tzd", "lye", "nyu", "lyd", "nyt", "Bwe", "Dwu", "Bwd", "bxu", "Dwt", "bxt", "tzF", "lyF", "nyh", "BwF", "Dwh", "bwx", "Aiq", "Ain", "Ayo", "kjf", "Aym", "Ayl", "Aif", "Ayv", "kze", "kzd", "Aye", "Byu", "Ayd", "Byt", "szp"};

    /* JADX INFO: renamed from: Z, reason: collision with root package name */
    private static final char[] f651Z = {'A', 'B', 'C', 'D', 'E', 'F', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '*', '+', '-'};

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private static final String[] f652a0 = {"00000", "00001", "00010", "00011", "00100", "00101", "00110", "00111", "01000", "01001", "01010", "01011", "01100", "01101", "01110", "01111", "10000", "10001", "10010", "10011", "10100", "10101", "10110", "10111", "11000", "11001", "11010", "11011", "11100", "11101", "11110", "11111", "01", "1111111101010100", "11111101000101001"};

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private static final String[] f653b0 = {"", "221311", "311311", "312211", "222211", "213211", "214111", "223111", "313111", "322111", "412111", "421111", "331111", "241111", "232111", "231211", "321211", "411211", "411121", "411112", "321112", "312112", "311212", "311221", "311131", "311122", "311113", "221113", "221122", "221131", "221221", "222121", "312121", "321121", "231121", "231112", "222112", "213112", "212212", "212221", "212131", "212122", "212113", "211213", "211123", "211132", "211141", "211231", "211222", "211312", "211321", "211411", "212311"};

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private static final String[] f654c0 = {"", "112231", "121231", "122131", "131131", "131221", "132121", "141121", "141211", "142111", "133111", "132211", "131311", "122311", "123211", "124111", "115111", "114211", "114121", "123121", "123112", "122212", "122221", "121321", "121411", "112411", "113311", "113221", "113212", "113122", "122122", "131122", "131113", "122113", "113113", "112213", "112222", "112312", "112321", "111421", "111331", "111322", "111232", "111223", "111133", "111124", "111214", "112114", "121114", "121123", "121132", "112132", "112141"};

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final int[] f655d0 = {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 11, 14, 17, 20, 24, 28, 8, 11, 14, 17, 20, 23, 26, 6, 8, 10, 12, 15, 20, 26, 32, 38, 44, 4, 6, 8, 10, 12, 15, 20, 26, 32, 38, 44, 7, 7, 7, 8, 8, 8, 8, 9, 9, 10, 11, 13, 15, 12, 14, 16, 18, 21, 26, 32, 38, 44, 50, 8, 12, 14, 16, 18, 21, 26, 32, 38, 44, 50, 0, 0, 0, 7, 7, 7, 7, 15, 15, 24, 34, 57, 84, 45, 70, 99, 115, 133, 154, 180, 212, 250, 294, 7, 45, 70, 99, 115, 133, 154, 180, 212, 250, 294};

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static final int[] f656e0 = {76, 925, 537, 597, 784, 691, 437, 237, 308, 436, 284, 646, 653, 428, 379, 567, 527, 622, 257, 289, 362, 501, 441, 205, 377, 457, 64, 244, 826, 841, 818, 691, 266, 612, 462, 45, 565, 708, 825, 213, 15, 68, 327, 602, 904, 597, 864, 757, 201, 646, 684, 347, 127, 388, 7, 69, 851, 764, 713, 342, 384, 606, 583, 322, 592, 678, 204, 184, 394, 692, 669, 677, 154, 187, 241, 286, 274, 354, 478, 915, 691, 833, 105, 215, 460, 829, 476, 109, 904, 664, 230, 5, 80, 74, 550, 575, 147, 868, 642, 274, 562, 232, 755, 599, 524, 801, 132, 295, 116, 442, 428, 295, 42, 176, 65, 279, 577, 315, 624, 37, 855, 275, 739, 120, 297, 312, 202, 560, 321, 233, 756, 760, 573, 108, 519, 781, 534, 129, 425, 681, 553, 422, 716, 763, 693, 624, 610, 310, 691, 347, 165, 193, 259, 568, 443, 284, 887, 544, 788, 93, 477, 760, 331, 608, 269, 121, 159, 830, 446, 893, 699, 245, 441, 454, 325, 858, 131, 847, 764, 169, 361, 575, 922, 525, 176, 586, 640, 321, 536, 742, 677, 742, 687, 284, 193, 517, 273, 494, 263, 147, 593, 800, 571, 320, 803, 133, 231, 390, 685, 330, 63, 410, 234, 228, 438, 848, 133, 703, 529, 721, 788, 322, 280, 159, 738, 586, 388, 684, 445, 680, 245, 595, 614, 233, 812, 32, 284, 658, 745, 229, 95, 689, 920, 771, 554, 289, 231, 125, 117, 518, 476, 36, 659, 848, 678, 64, 764, 840, 157, 915, 470, 876, 109, 25, 632, 405, 417, 436, 714, 60, 376, 97, 413, 706, 446, 21, 3, 773, 569, 267, 272, 213, 31, 560, 231, 758, 103, 271, 572, 436, 339, 730, 82, 285, 923, 797, 576, 875, 156, 706, 63, 81, 257, 874, 411, 416, 778, 50, 205, 303, 188, 535, 909, 155, 637, 230, 534, 96, 575, 102, 264, 233, 919, 593, 865, 26, 579, 623, 766, 146, 10, 739, 246, 127, 71, 244, 211, 477, 920, 876, 427, 820, 718, 435};

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static final int[] f657f0 = {1, 8, 36, 19, 9, 25, 1, 1, 8, 36, 19, 9, 27, 1, 7, 15, 25, 37, 1, 1, 21, 15, 1, 47, 1, 7, 15, 25, 37, 1, 1, 21, 15, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 7, 15, 25, 37, 17, 9, 29, 31, 25, 19, 1, 7, 15, 25, 37, 17, 9, 29, 31, 25, 9, 8, 36, 19, 17, 33, 1, 9, 8, 36, 19, 17, 35, 1, 7, 15, 25, 37, 33, 17, 37, 47, 49, 43, 1, 7, 15, 25, 37, 33, 17, 37, 47, 49, 0, 3, 6, 0, 6, 0, 0, 0, 3, 6, 0, 6, 6, 0, 0, 6, 0, 0, 0, 0, 6, 6, 0, 3, 0, 0, 6, 0, 0, 0, 0, 6, 6, 0};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private int f658A;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private int[] f660C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private b[] f661D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private int f662E;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private int f665H;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int[] f667J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private a f668K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private Q.a f669L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private String f670M;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private int f672O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private int f673P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private int f674Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private Integer f675R;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private Integer f677T;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private StringBuilder f678z;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private c f659B = c.CODE_128;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private final int[][] f663F = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 69, 7);

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private final int[] f664G = new int[180];

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private final int[] f666I = new int[13];

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private a f671N = a.CC_A;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private int f676S = 1;

    /* JADX INFO: renamed from: E2.q$a */
    public enum a {
        CC_A,
        CC_B,
        CC_C
    }

    /* JADX INFO: renamed from: E2.q$b */
    private enum b {
        NUMERIC,
        ALPHA,
        ISOIEC,
        INVALID_CHAR,
        ANY_ENC,
        ALPHA_OR_ISO
    }

    /* JADX INFO: renamed from: E2.q$c */
    public enum c {
        UPCA,
        UPCE,
        EAN,
        CODE_128,
        DATABAR_14,
        DATABAR_14_STACK,
        DATABAR_14_STACK_OMNI,
        DATABAR_LIMITED,
        DATABAR_EXPANDED,
        DATABAR_EXPANDED_STACK
    }

    public C0201q() {
        this.f403b = Q.a.GS1;
    }

    private boolean L() {
        int i3;
        int i4;
        int[] iArr = new int[200];
        b[] bVarArr = new b[200];
        iArr[0] = 1;
        bVarArr[0] = this.f661D[0];
        int i5 = 0;
        for (int i6 = 1; i6 < this.f660C.length; i6++) {
            b[] bVarArr2 = this.f661D;
            b bVar = bVarArr2[i6];
            if (bVar == bVarArr2[i6 - 1]) {
                iArr[i5] = iArr[i5] + 1;
            } else {
                i5++;
                iArr[i5] = 1;
                bVarArr[i5] = bVar;
            }
        }
        int i7 = i5 + 1;
        int i8 = 0;
        while (i8 < i7) {
            b bVar2 = bVarArr[i8];
            int i9 = i8 + 1;
            b bVar3 = bVarArr[i9];
            b bVar4 = b.ISOIEC;
            if (bVar2 == bVar4 && i8 != i5) {
                b bVar5 = b.ANY_ENC;
                if (bVar3 == bVar5 && iArr[i9] >= 4) {
                    bVarArr[i9] = b.NUMERIC;
                }
                if (bVar3 == bVar5 && iArr[i9] < 4) {
                    bVarArr[i9] = bVar4;
                }
                b bVar6 = b.ALPHA_OR_ISO;
                if (bVar3 == bVar6 && iArr[i9] >= 5) {
                    bVarArr[i9] = b.ALPHA;
                }
                if (bVar3 == bVar6 && iArr[i9] < 5) {
                    bVarArr[i9] = bVar4;
                }
            }
            if (bVar2 == b.ALPHA_OR_ISO) {
                bVarArr[i8] = b.ALPHA;
            }
            b bVar7 = b.ALPHA;
            if (bVar2 == bVar7 && i8 != i5) {
                b bVar8 = b.ANY_ENC;
                if (bVar3 == bVar8 && iArr[i9] >= 6) {
                    bVarArr[i9] = b.NUMERIC;
                }
                if (bVar3 == bVar8 && (i4 = iArr[i9]) < 6) {
                    if (i8 != i5 - 1 || i4 < 4) {
                        bVarArr[i9] = bVar7;
                    } else {
                        bVarArr[i9] = b.NUMERIC;
                    }
                }
            }
            if (bVar2 == b.ANY_ENC) {
                bVarArr[i8] = b.NUMERIC;
            }
            i8 = i9;
        }
        if (i7 > 1) {
            int i10 = 1;
            while (i10 < i7) {
                int i11 = i10 - 1;
                if (bVarArr[i11] == bVarArr[i10]) {
                    iArr[i11] = iArr[i11] + iArr[i10];
                    for (int i12 = i10 + 1; i12 < i7; i12++) {
                        int i13 = i12 - 1;
                        iArr[i13] = iArr[i12];
                        bVarArr[i13] = bVarArr[i12];
                    }
                    i7--;
                    i10--;
                }
                i10++;
            }
        }
        int i14 = 0;
        while (true) {
            i3 = i7 - 1;
            if (i14 >= i3) {
                break;
            }
            if (bVarArr[i14] == b.NUMERIC) {
                int i15 = iArr[i14];
                if ((i15 & 1) != 0) {
                    iArr[i14] = i15 - 1;
                    int i16 = i14 + 1;
                    iArr[i16] = iArr[i16] + 1;
                }
            }
            i14++;
        }
        int i17 = 0;
        for (int i18 = 0; i18 < i7; i18++) {
            for (int i19 = 0; i19 < iArr[i18]; i19++) {
                this.f661D[i17] = bVarArr[i18];
                i17++;
            }
        }
        return bVarArr[i3] == b.NUMERIC && (iArr[i3] & 1) != 0;
    }

    private void M(int i3, int i4) {
        if (this.f678z.length() % 6 == 0) {
            int[] iArr = this.f664G;
            int i5 = this.f665H;
            this.f665H = i5 + 1;
            iArr[i5] = 924;
        } else {
            int[] iArr2 = this.f664G;
            int i6 = this.f665H;
            this.f665H = i6 + 1;
            iArr2[i6] = 901;
        }
        int i7 = 0;
        while (i7 < i4) {
            int i8 = i4 - i7;
            if (6 <= i8) {
                i7 += 6;
                BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
                int i9 = 6;
                while (true) {
                    int i10 = i9 - 1;
                    if (i9 == 0) {
                        break;
                    }
                    bigIntegerValueOf = bigIntegerValueOf.or(BigInteger.valueOf(this.f667J[i3]).shiftLeft(i10 * 8));
                    i9 = i10;
                    i3++;
                }
                int i11 = 5;
                while (true) {
                    int i12 = i11 - 1;
                    if (i11 == 0) {
                        break;
                    }
                    this.f664G[this.f665H + i12] = bigIntegerValueOf.mod(BigInteger.valueOf(900L)).intValue();
                    bigIntegerValueOf = bigIntegerValueOf.divide(BigInteger.valueOf(900L));
                    i11 = i12;
                }
                this.f665H += 5;
            } else {
                i7 += i8;
                while (true) {
                    int i13 = i8 - 1;
                    if (i8 != 0) {
                        int[] iArr3 = this.f664G;
                        int i14 = this.f665H;
                        this.f665H = i14 + 1;
                        iArr3[i14] = this.f667J[i3];
                        i8 = i13;
                        i3++;
                    }
                }
            }
        }
    }

    private boolean N() {
        int i3;
        int length = this.f678z.length();
        a aVar = this.f668K;
        if (aVar == a.CC_A) {
            int i4 = this.f662E;
            if (i4 == 2) {
                if (length > 167) {
                    return false;
                }
                this.f672O = 167;
                if (length <= 138) {
                    this.f672O = 138;
                }
                if (length <= 118) {
                    this.f672O = 118;
                }
                if (length <= 108) {
                    this.f672O = 108;
                }
                if (length <= 88) {
                    this.f672O = 88;
                }
                if (length <= 78) {
                    this.f672O = 78;
                }
                if (length <= 59) {
                    this.f672O = 59;
                }
            } else if (i4 == 3) {
                if (length > 167) {
                    return false;
                }
                this.f672O = 167;
                if (length <= 138) {
                    this.f672O = 138;
                }
                if (length <= 118) {
                    this.f672O = 118;
                }
                if (length <= 98) {
                    this.f672O = 98;
                }
                if (length <= 78) {
                    this.f672O = 78;
                }
            } else if (i4 == 4) {
                if (length > 197) {
                    return false;
                }
                this.f672O = 197;
                if (length <= 167) {
                    this.f672O = 167;
                }
                if (length <= 138) {
                    this.f672O = 138;
                }
                if (length <= 108) {
                    this.f672O = 108;
                }
                if (length <= 78) {
                    this.f672O = 78;
                }
            }
        }
        if (aVar == a.CC_B) {
            int i5 = this.f662E;
            if (i5 == 2) {
                if (length > 336) {
                    return false;
                }
                this.f672O = 336;
                if (length <= 296) {
                    this.f672O = 296;
                }
                if (length <= 256) {
                    this.f672O = 256;
                }
                if (length <= 208) {
                    this.f672O = 208;
                }
                if (length <= 160) {
                    this.f672O = 160;
                }
                if (length <= 104) {
                    this.f672O = 104;
                }
                if (length <= 56) {
                    this.f672O = 56;
                }
            } else if (i5 == 3) {
                if (length > 768) {
                    return false;
                }
                this.f672O = 768;
                if (length <= 648) {
                    this.f672O = 648;
                }
                if (length <= 536) {
                    this.f672O = 536;
                }
                if (length <= 416) {
                    this.f672O = 416;
                }
                if (length <= 304) {
                    this.f672O = 304;
                }
                if (length <= 208) {
                    this.f672O = 208;
                }
                if (length <= 152) {
                    this.f672O = 152;
                }
                if (length <= 112) {
                    this.f672O = 112;
                }
                if (length <= 72) {
                    this.f672O = 72;
                }
                if (length <= 32) {
                    this.f672O = 32;
                }
            } else if (i5 == 4) {
                if (length > 1184) {
                    return false;
                }
                this.f672O = 1184;
                if (length <= 1016) {
                    this.f672O = 1016;
                }
                if (length <= 840) {
                    this.f672O = 840;
                }
                if (length <= 672) {
                    this.f672O = 672;
                }
                if (length <= 496) {
                    this.f672O = 496;
                }
                if (length <= 352) {
                    this.f672O = 352;
                }
                if (length <= 264) {
                    this.f672O = 264;
                }
                if (length <= 208) {
                    this.f672O = 208;
                }
                if (length <= 152) {
                    this.f672O = 152;
                }
                if (length <= 96) {
                    this.f672O = 96;
                }
                if (length <= 56) {
                    this.f672O = 56;
                }
            }
        }
        if (aVar == a.CC_C) {
            int i6 = length / 8;
            if (length % 8 != 0) {
                i6++;
            }
            int i7 = ((i6 / 6) * 5) + (i6 % 6);
            int i8 = i7 <= 1280 ? 6 : 7;
            if (i7 <= 640) {
                i8 = 5;
            }
            int i9 = i7 > 320 ? i8 : 4;
            if (i7 <= 160) {
                i9 = 3;
            }
            int i10 = i7 > 40 ? i9 : 2;
            this.f658A = i10;
            int i11 = 1;
            for (int i12 = 1; i12 <= i10 + 1; i12++) {
                i11 *= 2;
            }
            int i13 = i7 + i11 + 3;
            int i14 = this.f674Q;
            if (i14 == 0) {
                double d3 = i13;
                Double.isNaN(d3);
                this.f662E = (int) (Math.sqrt(d3 / 3.0d) + 0.5d);
            } else {
                this.f662E = (i14 - 53) / 17;
            }
            int i15 = this.f662E;
            if (i13 / i15 > 90) {
                this.f662E = i15 + 1;
            }
            int i16 = this.f662E;
            int i17 = i13 / i16;
            if (i13 % i16 != 0) {
                i17++;
            }
            while (true) {
                i3 = this.f662E;
                if (i3 <= i17 * 3) {
                    break;
                }
                int i18 = i3 - 1;
                this.f662E = i18;
                i17 = i13 / i18;
                if (i13 % i18 != 0) {
                    i17++;
                }
            }
            int i19 = ((i3 * i17) - i11) - 3;
            this.f672O = (((i19 / 5) * 6) + (i19 % 5)) * 8;
        }
        this.f673P = this.f672O - length;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x009f  */
    private void O() {
        int i3;
        int i4;
        int[] iArr = new int[8];
        int[] iArr2 = new int[5];
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < 13; i5++) {
            this.f666I[i5] = 0;
        }
        for (int i6 = 0; i6 < 28; i6++) {
            this.f664G[i6] = 0;
        }
        StringBuilder sb2 = new StringBuilder(208);
        sb2.append((CharSequence) this.f678z);
        for (int length = this.f678z.length(); length < 208; length++) {
            sb2.append('0');
        }
        for (int i7 = 0; i7 < 13; i7++) {
            int i8 = i7 * 16;
            this.f666I[i7] = 0;
            for (int i9 = 0; i9 < 16; i9++) {
                if (sb2.charAt(i8 + i9) == '1') {
                    int[] iArr3 = this.f666I;
                    iArr3[i7] = iArr3[i7] + (32768 >> i9);
                }
            }
        }
        X();
        int iU = U(this.f678z.length());
        int i10 = this.f662E;
        if (i10 != 2) {
            if (i10 != 3) {
                if (i10 != 4) {
                    i3 = 0;
                } else if (iU == 8) {
                    i3 = 12;
                } else if (iU == 11) {
                    i3 = 13;
                } else if (iU == 14) {
                    i3 = 14;
                } else if (iU == 17) {
                    i3 = 15;
                } else if (iU != 20) {
                    i3 = 0;
                } else {
                    i3 = 16;
                }
            } else if (iU == 8) {
                i3 = 7;
            } else if (iU == 10) {
                i3 = 8;
            } else if (iU == 12) {
                i3 = 9;
            } else if (iU == 14) {
                i3 = 10;
            } else if (iU != 17) {
                i3 = 0;
            } else {
                i3 = 11;
            }
        } else if (iU == 6) {
            i3 = 0;
        } else if (iU == 14) {
            i3 = 5;
        } else if (iU == 17) {
            i3 = 6;
        } else if (iU == 8) {
            i3 = 1;
        } else if (iU == 9) {
            i3 = 2;
        } else if (iU == 11) {
            i3 = 3;
        } else if (iU != 12) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        int[] iArr4 = f648W;
        int i11 = iArr4[i3];
        int i12 = i3 + 17;
        int i13 = iArr4[i12];
        int i14 = i3 + 34;
        int i15 = iArr4[i14];
        for (int i16 = 0; i16 < 8; i16++) {
            iArr[i16] = 0;
        }
        u("Composite Codewords: ");
        for (int i17 = 0; i17 < iU; i17++) {
            int i18 = i13 - 1;
            int i19 = (this.f664G[i17] + iArr[i18]) % 929;
            while (i18 >= 0) {
                if (i18 == 0) {
                    iArr[i18] = (929 - ((i19 * f646U[i15 + i18]) % 929)) % 929;
                } else {
                    iArr[i18] = ((iArr[i18 - 1] + 929) - ((i19 * f646U[i15 + i18]) % 929)) % 929;
                }
                i18--;
            }
            y(this.f664G[i17]);
        }
        v();
        for (int i20 = 0; i20 < i13; i20++) {
            int i21 = iArr[i20];
            if (i21 != 0) {
                iArr[i20] = 929 - i21;
            }
        }
        for (int i22 = i13 - 1; i22 >= 0; i22--) {
            this.f664G[iU] = iArr[i22];
            iU++;
        }
        int[] iArr5 = f649X;
        int i23 = iArr5[i3];
        int i24 = iArr5[i12];
        int i25 = iArr5[i14];
        int i26 = iArr5[i3 + 51] / 3;
        this.f416o = "";
        this.f418q = i11;
        this.f417p = new String[i11];
        this.f419r = new int[i11];
        for (int i27 = 0; i27 < i11; i27++) {
            int i28 = i26 * 929;
            for (int i29 = 0; i29 < 5; i29++) {
                iArr2[i29] = 0;
            }
            int i30 = 0;
            while (true) {
                i4 = this.f662E;
                if (i30 >= i4) {
                    break;
                }
                int i31 = i30 + 1;
                iArr2[i31] = this.f664G[(i4 * i27) + i30];
                i30 = i31;
            }
            String str = i4 != 3 ? "" + f653b0[i23] : "";
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str + "1");
            String[] strArr = f650Y;
            sb3.append(strArr[iArr2[1] + i28]);
            String str2 = sb3.toString() + "1";
            if (this.f662E == 3) {
                str2 = str2 + f654c0[i24];
            }
            if (this.f662E >= 2) {
                str2 = ((str2 + "1") + strArr[iArr2[2] + i28]) + "1";
            }
            if (this.f662E == 4) {
                str2 = str2 + f654c0[i24];
            }
            if (this.f662E >= 3) {
                str2 = ((str2 + "1") + strArr[iArr2[3] + i28]) + "1";
            }
            if (this.f662E == 4) {
                str2 = ((str2 + "1") + strArr[i28 + iArr2[4]]) + "1";
            }
            String str3 = (str2 + f653b0[i25]) + "1";
            sb.setLength(0);
            boolean z3 = true;
            for (int i32 = 0; i32 < str3.length(); i32++) {
                if (str3.charAt(i32) < '0' || str3.charAt(i32) > '9') {
                    sb.append(f652a0[G2.a.c(str3.charAt(i32), f651Z)]);
                } else {
                    for (int i33 = 0; i33 < str3.charAt(i32) - '0'; i33++) {
                        if (z3) {
                            sb.append('1');
                        } else {
                            sb.append('0');
                        }
                    }
                    z3 = !z3;
                }
            }
            this.f419r[i27] = 2;
            this.f417p[i27] = Q.a(sb);
            i23++;
            i24++;
            i25++;
            i26++;
            if (i23 == 53) {
                i23 = 1;
            }
            if (i24 == 53) {
                i24 = 1;
            }
            if (i25 == 53) {
                i25 = 1;
            }
            if (i26 == 3) {
                i26 = 0;
            }
        }
    }

    private void P() {
        int i3;
        int i4;
        int[] iArr = new int[50];
        int[] iArr2 = new int[5];
        StringBuilder sb = new StringBuilder();
        this.f667J = new int[(this.f678z.length() / 8) + 3];
        int length = this.f678z.length() / 8;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i5 * 8;
            this.f667J[i5] = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (this.f678z.charAt(i6 + i7) == '1') {
                    int[] iArr3 = this.f667J;
                    iArr3[i5] = iArr3[i5] + (128 >> i7);
                }
            }
        }
        this.f665H = 0;
        this.f664G[0] = 920;
        this.f665H = 1;
        M(0, length);
        int i8 = this.f662E;
        int i9 = 24;
        if (i8 == 2) {
            int i10 = this.f665H;
            int i11 = i10 <= 33 ? 12 : 13;
            if (i10 <= 29) {
                i11 = 11;
            }
            if (i10 <= 24) {
                i11 = 10;
            }
            if (i10 <= 19) {
                i11 = 9;
            }
            if (i10 <= 13) {
                i11 = 8;
            }
            i3 = i10 <= 8 ? 7 : i11;
        } else {
            i3 = 0;
        }
        if (i8 == 3) {
            int i12 = this.f665H;
            int i13 = i12 <= 70 ? 22 : 23;
            if (i12 <= 58) {
                i13 = 21;
            }
            if (i12 <= 46) {
                i13 = 20;
            }
            int i14 = i12 <= 34 ? 19 : i13;
            if (i12 <= 24) {
                i14 = 18;
            }
            if (i12 <= 18) {
                i14 = 17;
            }
            if (i12 <= 14) {
                i14 = 16;
            }
            i3 = i12 <= 6 ? 14 : i12 <= 10 ? 15 : i14;
        }
        if (i8 == 4) {
            int i15 = this.f665H;
            int i16 = i15 <= 108 ? 33 : 34;
            if (i15 <= 90) {
                i16 = 32;
            }
            if (i15 <= 72) {
                i16 = 31;
            }
            if (i15 <= 54) {
                i16 = 30;
            }
            int i17 = i15 > 39 ? i16 : 29;
            if (i15 <= 30) {
                i17 = 28;
            }
            if (i15 <= 24) {
                i17 = 27;
            }
            if (i15 <= 18) {
                i17 = 26;
            }
            if (i15 <= 12) {
                i17 = 25;
            }
            if (i15 > 8) {
                i9 = i17;
            }
        } else {
            i9 = i3;
        }
        int i18 = i9 - 1;
        int[] iArr4 = f655d0;
        int i19 = iArr4[i18];
        int i20 = i9 + 33;
        int i21 = iArr4[i20];
        int i22 = i9 + 67;
        int i23 = iArr4[i22];
        int i24 = i9 + 101;
        int i25 = iArr4[i24];
        for (int i26 = ((i19 * i21) - i23) - this.f665H; i26 > 0; i26--) {
            int[] iArr5 = this.f664G;
            int i27 = this.f665H;
            iArr5[i27] = 900;
            this.f665H = i27 + 1;
        }
        int i28 = this.f665H;
        for (int i29 = 0; i29 < 50; i29++) {
            iArr[i29] = 0;
        }
        u("Composite Codewords: ");
        int i30 = 0;
        while (i30 < i28) {
            int i31 = i23 - 1;
            int i32 = (this.f664G[i30] + iArr[i31]) % 929;
            while (i31 >= 0) {
                if (i31 == 0) {
                    iArr[i31] = (929 - ((i32 * f656e0[i25 + i31]) % 929)) % 929;
                } else {
                    iArr[i31] = ((iArr[i31 - 1] + 929) - ((i32 * f656e0[i25 + i31]) % 929)) % 929;
                }
                i31--;
                i25 = i25;
            }
            y(this.f664G[i30]);
            i30++;
            i25 = i25;
        }
        v();
        for (int i33 = 0; i33 < i23; i33++) {
            int i34 = iArr[i33];
            if (i34 != 0) {
                iArr[i33] = 929 - i34;
            }
        }
        int i35 = 1;
        int i36 = i23 - 1;
        while (i36 >= 0) {
            int[] iArr6 = this.f664G;
            int i37 = this.f665H;
            iArr6[i37] = iArr[i36];
            this.f665H = i37 + i35;
            i36--;
            i35 = 1;
        }
        int[] iArr7 = f657f0;
        int i38 = iArr7[i18];
        int i39 = iArr7[i20];
        int i40 = iArr7[i22];
        int i41 = iArr7[i24] / 3;
        this.f416o = "";
        this.f418q = i21;
        this.f417p = new String[i21];
        this.f419r = new int[i21];
        int i42 = 0;
        while (i42 < i21) {
            int i43 = i41 * 929;
            for (int i44 = 0; i44 < 5; i44++) {
                iArr2[i44] = 0;
            }
            int i45 = 0;
            while (i45 < i19) {
                int i46 = i45 + 1;
                iArr2[i46] = this.f664G[(i42 * i19) + i45];
                i45 = i46;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            String[] strArr = f653b0;
            sb2.append(strArr[i38]);
            String str = sb2.toString() + "1";
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            String[] strArr2 = f650Y;
            sb3.append(strArr2[i43 + iArr2[1]]);
            String str2 = sb3.toString() + "1";
            int i47 = i19;
            if (this.f662E == 3) {
                str2 = str2 + f654c0[i39];
            }
            if (this.f662E >= 2) {
                str2 = ((str2 + "1") + strArr2[iArr2[2] + i43]) + "1";
            }
            if (this.f662E == 4) {
                str2 = str2 + f654c0[i39];
            }
            if (this.f662E >= 3) {
                str2 = ((str2 + "1") + strArr2[iArr2[3] + i43]) + "1";
            }
            if (this.f662E == 4) {
                str2 = ((str2 + "1") + strArr2[i43 + iArr2[4]]) + "1";
            }
            String str3 = (str2 + strArr[i40]) + "1";
            sb.setLength(0);
            boolean z3 = true;
            for (int i48 = 0; i48 < str3.length(); i48++) {
                if (str3.charAt(i48) < '0' || str3.charAt(i48) > '9') {
                    sb.append(f652a0[G2.a.c(str3.charAt(i48), f651Z)]);
                } else {
                    for (int i49 = 0; i49 < str3.charAt(i48) - '0'; i49++) {
                        if (z3) {
                            sb.append('1');
                        } else {
                            sb.append('0');
                        }
                    }
                    z3 = !z3;
                }
            }
            this.f417p[i42] = Q.a(sb);
            this.f419r[i42] = 2;
            i38++;
            i39++;
            int i50 = i40 + 1;
            i41++;
            if (i38 == 53) {
                i38 = 1;
            }
            if (i39 == 53) {
                i39 = 1;
            }
            if (i50 == 53) {
                i4 = 3;
                i40 = 1;
            } else {
                i40 = i50;
                i4 = 3;
            }
            if (i41 == i4) {
                i41 = 0;
            }
            i42++;
            i19 = i47;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:102:0x0156  */
    /* JADX WARN: Code duplicated, block: B:109:0x0168  */
    /* JADX WARN: Code duplicated, block: B:164:0x0236  */
    /* JADX WARN: Code duplicated, block: B:166:0x0241 A[LOOP:5: B:166:0x0241->B:184:0x0281, LOOP_START, PHI: r1
      0x0241: PHI (r1v64 int) = (r1v55 int), (r1v68 int) binds: [B:165:0x023f, B:184:0x0281] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:178:0x026e  */
    /* JADX WARN: Code duplicated, block: B:186:0x0286  */
    /* JADX WARN: Code duplicated, block: B:188:0x0289 A[LOOP:6: B:188:0x0289->B:215:0x02fa, LOOP_START, PHI: r1
      0x0289: PHI (r1v59 int) = (r1v56 int), (r1v63 int) binds: [B:187:0x0287, B:215:0x02fa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:200:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:202:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:204:0x02be  */
    /* JADX WARN: Code duplicated, block: B:205:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:206:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:207:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:208:0x02de  */
    /* JADX WARN: Code duplicated, block: B:209:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:218:0x0302  */
    /* JADX WARN: Code duplicated, block: B:220:0x0305  */
    /* JADX WARN: Code duplicated, block: B:221:0x0318  */
    /* JADX WARN: Code duplicated, block: B:224:0x0326  */
    /* JADX WARN: Code duplicated, block: B:227:0x0332  */
    /* JADX WARN: Code duplicated, block: B:229:0x0337  */
    /* JADX WARN: Code duplicated, block: B:230:0x033e  */
    /* JADX WARN: Code duplicated, block: B:236:0x034e  */
    /* JADX WARN: Code duplicated, block: B:239:0x0359  */
    /* JADX WARN: Code duplicated, block: B:242:0x0364  */
    /* JADX WARN: Code duplicated, block: B:245:0x036f  */
    /* JADX WARN: Code duplicated, block: B:248:0x037a  */
    /* JADX WARN: Code duplicated, block: B:251:0x0385  */
    /* JADX WARN: Code duplicated, block: B:254:0x0390  */
    /* JADX WARN: Code duplicated, block: B:262:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:265:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:268:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:271:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:274:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:281:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:284:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:286:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:288:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:293:0x040b  */
    /* JADX WARN: Code duplicated, block: B:295:0x0413  */
    /* JADX WARN: Code duplicated, block: B:297:0x041a  */
    /* JADX WARN: Code duplicated, block: B:302:0x042e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:303:0x0430  */
    /* JADX WARN: Code duplicated, block: B:306:0x0435  */
    /* JADX WARN: Code duplicated, block: B:315:0x0455  */
    /* JADX WARN: Code duplicated, block: B:333:0x04a4  */
    /* JADX WARN: Code duplicated, block: B:336:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:339:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:342:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:345:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:348:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:351:0x04fe  */
    /* JADX WARN: Code duplicated, block: B:354:0x050d  */
    /* JADX WARN: Code duplicated, block: B:357:0x051c  */
    /* JADX WARN: Code duplicated, block: B:360:0x052b  */
    /* JADX WARN: Code duplicated, block: B:363:0x053a  */
    /* JADX WARN: Code duplicated, block: B:366:0x0549  */
    /* JADX WARN: Code duplicated, block: B:369:0x0558  */
    /* JADX WARN: Code duplicated, block: B:372:0x0567  */
    /* JADX WARN: Code duplicated, block: B:375:0x0576  */
    /* JADX WARN: Code duplicated, block: B:378:0x0585  */
    /* JADX WARN: Code duplicated, block: B:381:0x0594  */
    /* JADX WARN: Code duplicated, block: B:384:0x05a3  */
    /* JADX WARN: Code duplicated, block: B:387:0x05b2  */
    /* JADX WARN: Code duplicated, block: B:390:0x05c1  */
    /* JADX WARN: Code duplicated, block: B:393:0x05d0  */
    /* JADX WARN: Code duplicated, block: B:396:0x05df  */
    /* JADX WARN: Code duplicated, block: B:399:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:409:0x061a  */
    /* JADX WARN: Code duplicated, block: B:414:0x0634  */
    /* JADX WARN: Code duplicated, block: B:421:0x0650  */
    /* JADX WARN: Code duplicated, block: B:424:0x065f  */
    /* JADX WARN: Code duplicated, block: B:427:0x066e  */
    /* JADX WARN: Code duplicated, block: B:430:0x067d  */
    /* JADX WARN: Code duplicated, block: B:433:0x068c  */
    /* JADX WARN: Code duplicated, block: B:436:0x069b  */
    /* JADX WARN: Code duplicated, block: B:438:0x06a7  */
    /* JADX WARN: Code duplicated, block: B:440:0x06b9  */
    /* JADX WARN: Code duplicated, block: B:442:0x06c3  */
    /* JADX WARN: Code duplicated, block: B:444:0x06ca  */
    /* JADX WARN: Code duplicated, block: B:445:0x06d2  */
    /* JADX WARN: Code duplicated, block: B:448:0x06d9  */
    /* JADX WARN: Code duplicated, block: B:449:0x06dc  */
    /* JADX WARN: Code duplicated, block: B:455:0x06ed  */
    /* JADX WARN: Code duplicated, block: B:458:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:462:0x070c  */
    /* JADX WARN: Code duplicated, block: B:464:0x0714  */
    /* JADX WARN: Code duplicated, block: B:467:0x071b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:469:0x071d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:470:0x071f  */
    /* JADX WARN: Code duplicated, block: B:472:0x0728  */
    /* JADX WARN: Code duplicated, block: B:473:0x0730  */
    /* JADX WARN: Code duplicated, block: B:478:0x0741  */
    /* JADX WARN: Code duplicated, block: B:481:0x0756  */
    /* JADX WARN: Code duplicated, block: B:483:0x075c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:485:0x075e  */
    /* JADX WARN: Code duplicated, block: B:487:0x0785 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:488:0x0787  */
    /* JADX WARN: Code duplicated, block: B:493:0x079d  */
    /* JADX WARN: Code duplicated, block: B:496:0x07ae A[LOOP:11: B:494:0x07a4->B:496:0x07ae, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:499:0x07c0  */
    /* JADX WARN: Code duplicated, block: B:504:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:527:0x03e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:531:0x0404 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:533:0x0401 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:534:0x0401 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:535:0x041f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:537:0x041c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:538:0x041c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:541:0x07b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:60:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:70:0x0112  */
    /* JADX WARN: Code duplicated, block: B:71:0x0114 A[FALL_THROUGH, PHI: r19
      0x0114: PHI (r19v2 int) = (r19v1 int), (r19v3 int) binds: [B:68:0x010e, B:70:0x0112] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:89:0x013d  */
    /* JADX WARN: Code duplicated, block: B:98:0x014e  */
    /* JADX WARN: Instruction removed from duplicated block: B:485:0x075e, please report this as an issue */
    private boolean Q() {
        int i3;
        boolean z3;
        boolean z4;
        int[] iArr;
        Object[] objArr;
        int[] iArr2;
        int length;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z5;
        int[] iArr3;
        int i8;
        int[] iArr4;
        int i9;
        int[] iArr5;
        boolean zL;
        int i10;
        int iOrdinal;
        int i11;
        int[] iArr6;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        b bVar;
        int i21;
        int i22;
        int i23;
        int i24;
        b bVar2;
        b[] bVarArr;
        b bVar3;
        b bVar4;
        int i25;
        b[] bVarArr2;
        b bVar5;
        b bVar6;
        int i26;
        int i27;
        int length2;
        int length3;
        int[] iArrCopyOfRange;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        boolean z6;
        boolean z7;
        int i35;
        char c3;
        char c4;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        int[] iArr7;
        int i41;
        int i42;
        int i43;
        int[] iArr8;
        int i44;
        int i45;
        int i46;
        this.f658A = 0;
        this.f672O = 0;
        int[] iArr9 = this.f667J;
        int i47 = iArr9[0];
        char c5 = (i47 != 49 || !((i46 = iArr9[1]) == 48 || i46 == 49 || i46 == 55) || iArr9.length < 8) ? (char) 1 : (char) 2;
        if (i47 == 57 && iArr9[1] == 48) {
            c5 = 3;
        }
        u("Composite Encodation: ");
        if (c5 == 1) {
            w("0");
        } else if (c5 == 2) {
            w("10");
        } else if (c5 == 3) {
            w("11");
        }
        StringBuilder sb = new StringBuilder();
        this.f678z = sb;
        if (c5 == 1) {
            sb.append('0');
        }
        if (c5 == 2) {
            this.f678z.append("10");
            int[] iArr10 = this.f667J;
            if (iArr10[1] == 48) {
                this.f678z.append("11");
                i3 = 0;
            } else {
                G2.f.a(this.f678z, ((((iArr10[2] - 48) * 10) + (iArr10[3] - 48)) * 384) + (((((iArr10[4] - 48) * 10) + (iArr10[5] - 48)) - 1) * 32) + ((iArr10[6] - 48) * 10) + (iArr10[7] - 48), 16);
                if (this.f667J[1] == 49) {
                    this.f678z.append('0');
                } else {
                    this.f678z.append('1');
                }
                i3 = 8;
            }
            int i48 = i3 + 2;
            int[] iArr11 = this.f667J;
            if (i48 < iArr11.length && iArr11[i3] == 49 && iArr11[i3 + 1] == 48) {
                i3 = i48;
            } else {
                z3 = true;
            }
            if (c5 == 3) {
                int[] iArr12 = this.f667J;
                length2 = iArr12.length;
                for (length3 = iArr12.length - 1; length3 > 2; length3--) {
                    if (this.f667J[length3] == -1) {
                        length2 = length3;
                    }
                }
                iArrCopyOfRange = Arrays.copyOfRange(this.f667J, 2, length2);
                i29 = 0;
                i30 = 0;
                i31 = 0;
                for (int i49 : iArrCopyOfRange) {
                    if (i49 >= 65 && i49 <= 90) {
                        i29++;
                    }
                    if (i49 >= 48 && i49 <= 57) {
                        i30++;
                    }
                    switch (i49) {
                        case 42:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                            i31++;
                        case 43:
                        default:
                            if ((i49 >= 48 || i49 > 57) && ((i49 < 65 || i49 > 90) && i49 != 42 && i49 != 44 && i49 != 45 && i49 != 46 && i49 != 47)) {
                                throw new H("Invalid AI 90 data");
                            }
                            break;
                            break;
                    }
                }
                i32 = -1;
                for (i33 = 3; i33 >= 0; i33--) {
                    if (i33 >= iArrCopyOfRange.length && (i45 = iArrCopyOfRange[i33]) >= 65 && i45 <= 90) {
                        i32 = i33;
                    }
                }
                z6 = false;
                for (i34 = 0; i34 < i32; i34++) {
                    i44 = iArrCopyOfRange[i34];
                    if (i44 >= 48 || i44 > 57) {
                        z6 = true;
                    }
                }
                if (i32 >= 1 || iArrCopyOfRange[0] != 48) {
                    z7 = false;
                } else {
                    z7 = true;
                }
                if (i32 != -1 || z6 || z7) {
                    this.f678z.append('0');
                    i35 = 0;
                    c3 = 2;
                    c4 = 0;
                    i36 = 0;
                } else {
                    this.f678z.append("11");
                    int i50 = i30 - i32;
                    int i51 = i29 - 1;
                    if (i31 > 0) {
                        this.f678z.append('0');
                        c4 = 1;
                    } else if (i51 > i50) {
                        this.f678z.append("11");
                        c4 = 2;
                    } else {
                        this.f678z.append("10");
                        c4 = 3;
                    }
                    int length4 = iArrCopyOfRange.length;
                    int i52 = length4 + 2;
                    int[] iArr13 = this.f667J;
                    if (i52 >= iArr13.length || iArr13[i52] != -1) {
                        i36 = 0;
                    } else {
                        int i53 = length4 + 4;
                        i36 = (i53 < iArr13.length && iArr13[length4 + 3] == 50 && iArr13[i53] == 49) ? 1 : 0;
                        int i54 = length4 + 6;
                        if (i54 < iArr13.length && iArr13[length4 + 3] == 56 && iArr13[i53] == 48 && iArr13[length4 + 5] == 48 && iArr13[i54] == 52) {
                            i36 = 2;
                        }
                    }
                    if (i36 == 0) {
                        this.f678z.append('0');
                    } else if (i36 == 1) {
                        this.f678z.append("10");
                    } else if (i36 == 2) {
                        this.f678z.append("11");
                    }
                    int i55 = 0;
                    for (int i56 = 0; i56 < i32; i56++) {
                        i55 = (i55 * 10) + (iArrCopyOfRange[i56] - 48);
                    }
                    int iIndexOf = i55 < 31 ? "BDHIJKLNPQRSTVWZ".indexOf(iArrCopyOfRange[i32]) : -1;
                    if (iIndexOf != -1) {
                        G2.f.a(this.f678z, i55, 5);
                        G2.f.a(this.f678z, iIndexOf, 4);
                    } else {
                        this.f678z.append("11111");
                        G2.f.a(this.f678z, i55, 10);
                        G2.f.a(this.f678z, iArrCopyOfRange[i32] - 65, 5);
                    }
                    i35 = 3 + i32;
                    c3 = 2;
                }
                if (c4 == c3) {
                    while (true) {
                        i41 = this.f667J[i35];
                        if (i41 >= 48 && i41 <= 57) {
                            G2.f.a(this.f678z, i41 + 4, 6);
                        }
                        i42 = this.f667J[i35];
                        if (i42 >= 65 && i42 <= 90) {
                            G2.f.a(this.f678z, i42 - 65, 5);
                        }
                        if (this.f667J[i35] == -1) {
                            this.f678z.append("11111");
                        }
                        i43 = i35 + 1;
                        iArr8 = this.f667J;
                        if (iArr8[i35] == -1 && i43 < iArr8.length) {
                            i35 = i43;
                        }
                    }
                    i35 = i43;
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (c4 == 1) {
                    while (true) {
                        i37 = this.f667J[i35];
                        if (i37 >= 48 && i37 <= 57) {
                            G2.f.a(this.f678z, i37 - 43, 5);
                        }
                        i38 = this.f667J[i35];
                        if (i38 >= 65 && i38 <= 90) {
                            G2.f.a(this.f678z, i38 - 33, 6);
                        }
                        i39 = this.f667J[i35];
                        if (i39 != -1) {
                            this.f678z.append("01111");
                        } else if (i39 != 42) {
                            switch (i39) {
                                case 44:
                                    this.f678z.append("111011");
                                    break;
                                case 45:
                                    this.f678z.append("111100");
                                    break;
                                case 46:
                                    this.f678z.append("111101");
                                    break;
                                case 47:
                                    this.f678z.append("111110");
                                    break;
                            }
                        } else {
                            this.f678z.append("111010");
                        }
                        i40 = i35 + 1;
                        iArr7 = this.f667J;
                        if (iArr7[i35] == -1 && i40 < iArr7.length) {
                            i35 = i40;
                        }
                    }
                    i35 = i40;
                }
                i3 = i35 + (i36 * 2);
            } else {
                z4 = false;
            }
            if (z3) {
                int[] iArr14 = this.f667J;
                int[] iArr15 = new int[(iArr14.length - i3) + 1];
                this.f660C = iArr15;
                iArr15[0] = -1;
                System.arraycopy(iArr14, i3, iArr15, 1, iArr15.length - 1);
            } else {
                int[] iArr16 = this.f667J;
                this.f660C = Arrays.copyOfRange(iArr16, i3, iArr16.length);
            }
            iArr = this.f660C;
            if (iArr.length != 0) {
                this.f661D = new b[iArr.length];
                i7 = 0;
                z5 = false;
                while (true) {
                    iArr3 = this.f660C;
                    if (i7 < iArr3.length) {
                        i27 = iArr3[i7];
                        if (i27 == -1) {
                            this.f661D[i7] = b.ANY_ENC;
                        } else if (i27 >= 32 || i27 > 122) {
                            this.f661D[i7] = b.INVALID_CHAR;
                            z5 = true;
                        } else {
                            this.f661D[i7] = b.ISOIEC;
                        }
                        if (i27 == 35) {
                            this.f661D[i7] = b.INVALID_CHAR;
                            z5 = true;
                        }
                        if (i27 == 36) {
                            this.f661D[i7] = b.INVALID_CHAR;
                            z5 = true;
                        }
                        if (i27 == 64) {
                            this.f661D[i7] = b.INVALID_CHAR;
                            z5 = true;
                        }
                        if (i27 == 92) {
                            this.f661D[i7] = b.INVALID_CHAR;
                            z5 = true;
                        }
                        if (i27 == 94) {
                            this.f661D[i7] = b.INVALID_CHAR;
                            z5 = true;
                        }
                        if (i27 == 96) {
                            this.f661D[i7] = b.INVALID_CHAR;
                            z5 = true;
                        }
                        if (i27 >= 65 && i27 <= 90) {
                            this.f661D[i7] = b.ALPHA_OR_ISO;
                        }
                        if (i27 == 42) {
                            this.f661D[i7] = b.ALPHA_OR_ISO;
                        }
                        if (i27 == 44) {
                            this.f661D[i7] = b.ALPHA_OR_ISO;
                        }
                        if (i27 == 45) {
                            this.f661D[i7] = b.ALPHA_OR_ISO;
                        }
                        if (i27 == 46) {
                            this.f661D[i7] = b.ALPHA_OR_ISO;
                        }
                        if (i27 == 47) {
                            this.f661D[i7] = b.ALPHA_OR_ISO;
                        }
                        if (i27 < 48 && i27 <= 57) {
                            this.f661D[i7] = b.ANY_ENC;
                        }
                        i7++;
                    } else {
                        if (!z5) {
                            throw new H("Invalid characters in input data");
                        }
                        i8 = 0;
                        while (true) {
                            iArr4 = this.f660C;
                            if (i8 < iArr4.length - 1) {
                                bVarArr2 = this.f661D;
                                bVar5 = bVarArr2[i8];
                                bVar6 = b.ISOIEC;
                                if (bVar5 == bVar6) {
                                    i26 = i8 + 1;
                                    if (iArr4[i26] == -1) {
                                        bVarArr2[i26] = bVar6;
                                    }
                                }
                                i8++;
                            } else {
                                i9 = 0;
                                while (true) {
                                    iArr5 = this.f660C;
                                    if (i9 < iArr5.length - 1) {
                                        bVarArr = this.f661D;
                                        bVar3 = bVarArr[i9];
                                        bVar4 = b.ALPHA_OR_ISO;
                                        if (bVar3 == bVar4) {
                                            i25 = i9 + 1;
                                            if (iArr5[i25] == -1) {
                                                bVarArr[i25] = bVar4;
                                            }
                                        }
                                        i9++;
                                    } else {
                                        zL = L();
                                        i10 = 0;
                                        do {
                                            iOrdinal = this.f661D[i10].ordinal();
                                            if (iOrdinal != 0) {
                                                if (i10 != 0) {
                                                    i17 = i10 - 1;
                                                    if (this.f661D[i17] != b.NUMERIC) {
                                                        i11 = -1;
                                                        if (this.f660C[i17] != -1) {
                                                            this.f678z.append("000");
                                                        }
                                                    } else {
                                                        i11 = -1;
                                                    }
                                                } else {
                                                    i11 = -1;
                                                }
                                                iArr6 = this.f660C;
                                                i12 = iArr6[i10];
                                                if (i12 != i11) {
                                                    i13 = i12 - 48;
                                                } else {
                                                    i13 = 10;
                                                }
                                                if (i10 < iArr6.length - 1 || (i16 = iArr6[i10 + 1]) == i11) {
                                                    i14 = 10;
                                                    i15 = 10;
                                                } else {
                                                    i15 = i16 - 48;
                                                    i14 = 10;
                                                }
                                                if (i13 == i14 || i15 != i14) {
                                                    G2.f.a(this.f678z, (i13 * 11) + i15 + 8, 7);
                                                    i10 += 2;
                                                }
                                            } else if (iOrdinal != 1) {
                                                if (i10 != 0 || (bVar = this.f661D[(i20 = i10 - 1)]) == b.NUMERIC || this.f660C[i20] == -1) {
                                                    this.f678z.append("0000");
                                                } else if (bVar == b.ISOIEC) {
                                                    this.f678z.append("00100");
                                                }
                                                i18 = this.f660C[i10];
                                                if (i18 < 48 && i18 <= 57) {
                                                    G2.f.a(this.f678z, i18 - 43, 5);
                                                }
                                                i19 = this.f660C[i10];
                                                if (i19 >= 65 && i19 <= 90) {
                                                    G2.f.a(this.f678z, i19 - 33, 6);
                                                }
                                                if (this.f660C[i10] == -1) {
                                                    this.f678z.append("01111");
                                                }
                                                if (this.f660C[i10] == 42) {
                                                    this.f678z.append("111010");
                                                }
                                                if (this.f660C[i10] == 44) {
                                                    this.f678z.append("111011");
                                                }
                                                if (this.f660C[i10] == 45) {
                                                    this.f678z.append("111100");
                                                }
                                                if (this.f660C[i10] == 46) {
                                                    this.f678z.append("111101");
                                                }
                                                if (this.f660C[i10] == 47) {
                                                    this.f678z.append("111110");
                                                }
                                                i10++;
                                            } else if (iOrdinal == 2) {
                                                if (i10 != 0 || (bVar2 = this.f661D[(i24 = i10 - 1)]) == b.NUMERIC || this.f660C[i24] == -1) {
                                                    this.f678z.append("0000");
                                                    this.f678z.append("00100");
                                                } else if (bVar2 == b.ALPHA) {
                                                    this.f678z.append("00100");
                                                }
                                                i21 = this.f660C[i10];
                                                if (i21 >= 48 && i21 <= 57) {
                                                    G2.f.a(this.f678z, i21 - 43, 5);
                                                }
                                                i22 = this.f660C[i10];
                                                if (i22 >= 65 && i22 <= 90) {
                                                    G2.f.a(this.f678z, i22 - 1, 7);
                                                }
                                                i23 = this.f660C[i10];
                                                if (i23 >= 97 && i23 <= 122) {
                                                    G2.f.a(this.f678z, i23 - 7, 7);
                                                }
                                                if (this.f660C[i10] == -1) {
                                                    this.f678z.append("01111");
                                                }
                                                if (this.f660C[i10] == 33) {
                                                    this.f678z.append("11101000");
                                                }
                                                if (this.f660C[i10] == 34) {
                                                    this.f678z.append("11101001");
                                                }
                                                if (this.f660C[i10] == 37) {
                                                    this.f678z.append("11101010");
                                                }
                                                if (this.f660C[i10] == 38) {
                                                    this.f678z.append("11101011");
                                                }
                                                if (this.f660C[i10] == 39) {
                                                    this.f678z.append("11101100");
                                                }
                                                if (this.f660C[i10] == 40) {
                                                    this.f678z.append("11101101");
                                                }
                                                if (this.f660C[i10] == 41) {
                                                    this.f678z.append("11101110");
                                                }
                                                if (this.f660C[i10] == 42) {
                                                    this.f678z.append("11101111");
                                                }
                                                if (this.f660C[i10] == 43) {
                                                    this.f678z.append("11110000");
                                                }
                                                if (this.f660C[i10] == 44) {
                                                    this.f678z.append("11110001");
                                                }
                                                if (this.f660C[i10] == 45) {
                                                    this.f678z.append("11110010");
                                                }
                                                if (this.f660C[i10] == 46) {
                                                    this.f678z.append("11110011");
                                                }
                                                if (this.f660C[i10] == 47) {
                                                    this.f678z.append("11110100");
                                                }
                                                if (this.f660C[i10] == 58) {
                                                    this.f678z.append("11110101");
                                                }
                                                if (this.f660C[i10] == 59) {
                                                    this.f678z.append("11110110");
                                                }
                                                if (this.f660C[i10] == 60) {
                                                    this.f678z.append("11110111");
                                                }
                                                if (this.f660C[i10] == 61) {
                                                    this.f678z.append("11111000");
                                                }
                                                if (this.f660C[i10] == 62) {
                                                    this.f678z.append("11111001");
                                                }
                                                if (this.f660C[i10] == 63) {
                                                    this.f678z.append("11111010");
                                                }
                                                if (this.f660C[i10] == 95) {
                                                    this.f678z.append("11111011");
                                                }
                                                if (this.f660C[i10] == 32) {
                                                    this.f678z.append("11111100");
                                                }
                                                i10++;
                                            }
                                        } while (i10 + (zL ? 1 : 0) < this.f660C.length);
                                        objArr = zL ? 1 : 0;
                                        z4 = false;
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                objArr = null;
            }
            if (!N()) {
                return false;
            }
            if (objArr != null) {
                int[] iArr17 = this.f660C;
                i5 = iArr17[iArr17.length - 1];
                if (i5 == -1) {
                    this.f678z.append("000001111");
                } else {
                    i6 = this.f673P;
                    if (i6 >= 4 || i6 > 6) {
                        G2.f.a(this.f678z, ((i5 - 48) * 11) + 18, 7);
                    } else {
                        G2.f.a(this.f678z, i5 - 47, 4);
                    }
                }
            }
            if (this.f678z.length() <= 11805) {
                throw new H("Input too long");
            }
            if (!N()) {
                return false;
            }
            w("Composite Binary Length: " + this.f678z.length());
            Y();
            if (this.f678z.length() < this.f672O) {
                if (z4) {
                    this.f678z.append("11111");
                }
                iArr2 = this.f660C;
                if (iArr2.length != 0 || this.f661D[iArr2.length - 1] == b.NUMERIC) {
                    this.f678z.append("0000");
                }
                while (true) {
                    length = this.f678z.length();
                    i4 = this.f672O;
                    if (length < i4) {
                        this.f678z.append("00100");
                    } else {
                        StringBuilder sb2 = this.f678z;
                        sb2.delete(i4, sb2.length());
                    }
                }
            }
            return true;
        }
        i3 = 0;
        z3 = false;
        if (c5 == 3) {
            int[] iArr18 = this.f667J;
            length2 = iArr18.length;
            while (length3 > 2) {
                if (this.f667J[length3] == -1) {
                    length2 = length3;
                }
            }
            iArrCopyOfRange = Arrays.copyOfRange(this.f667J, 2, length2);
            i29 = 0;
            i30 = 0;
            i31 = 0;
            while (i28 < iArrCopyOfRange.length) {
                if (i49 >= 65) {
                    i29++;
                }
                if (i49 >= 48) {
                    i30++;
                }
                switch (i49) {
                    case 42:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                        i31++;
                    case 43:
                    default:
                        if (i49 >= 48) {
                            throw new H("Invalid AI 90 data");
                        }
                        throw new H("Invalid AI 90 data");
                        break;
                }
            }
            i32 = -1;
            while (i33 >= 0) {
                if (i33 >= iArrCopyOfRange.length) {
                }
            }
            z6 = false;
            while (i34 < i32) {
                i44 = iArrCopyOfRange[i34];
                if (i44 >= 48) {
                    z6 = true;
                } else {
                    z6 = true;
                }
            }
            if (i32 >= 1) {
                z7 = false;
            } else {
                z7 = false;
            }
            if (i32 != -1) {
                this.f678z.append('0');
                i35 = 0;
                c3 = 2;
                c4 = 0;
                i36 = 0;
            } else {
                this.f678z.append('0');
                i35 = 0;
                c3 = 2;
                c4 = 0;
                i36 = 0;
            }
            if (c4 == c3) {
                while (true) {
                    i41 = this.f667J[i35];
                    if (i41 >= 48) {
                        G2.f.a(this.f678z, i41 + 4, 6);
                    }
                    i42 = this.f667J[i35];
                    if (i42 >= 65) {
                        G2.f.a(this.f678z, i42 - 65, 5);
                    }
                    if (this.f667J[i35] == -1) {
                        this.f678z.append("11111");
                    }
                    i43 = i35 + 1;
                    iArr8 = this.f667J;
                    if (iArr8[i35] == -1) {
                    }
                    i35 = i43;
                    z4 = true;
                    i35 = i43;
                }
            } else {
                z4 = false;
            }
            if (c4 == 1) {
                while (true) {
                    i37 = this.f667J[i35];
                    if (i37 >= 48) {
                        G2.f.a(this.f678z, i37 - 43, 5);
                    }
                    i38 = this.f667J[i35];
                    if (i38 >= 65) {
                        G2.f.a(this.f678z, i38 - 33, 6);
                    }
                    i39 = this.f667J[i35];
                    if (i39 != -1) {
                        this.f678z.append("01111");
                    } else if (i39 != 42) {
                        switch (i39) {
                            case 44:
                                this.f678z.append("111011");
                                break;
                            case 45:
                                this.f678z.append("111100");
                                break;
                            case 46:
                                this.f678z.append("111101");
                                break;
                            case 47:
                                this.f678z.append("111110");
                                break;
                        }
                    } else {
                        this.f678z.append("111010");
                    }
                    i40 = i35 + 1;
                    iArr7 = this.f667J;
                    if (iArr7[i35] == -1) {
                    }
                    i35 = i40;
                    i35 = i40;
                }
            }
            i3 = i35 + (i36 * 2);
        } else {
            z4 = false;
        }
        if (z3) {
            int[] iArr19 = this.f667J;
            int[] iArr110 = new int[(iArr19.length - i3) + 1];
            this.f660C = iArr110;
            iArr110[0] = -1;
            System.arraycopy(iArr19, i3, iArr110, 1, iArr110.length - 1);
        } else {
            int[] iArr111 = this.f667J;
            this.f660C = Arrays.copyOfRange(iArr111, i3, iArr111.length);
        }
        iArr = this.f660C;
        if (iArr.length != 0) {
            this.f661D = new b[iArr.length];
            i7 = 0;
            z5 = false;
            while (true) {
                iArr3 = this.f660C;
                if (i7 < iArr3.length) {
                    i27 = iArr3[i7];
                    if (i27 == -1) {
                        this.f661D[i7] = b.ANY_ENC;
                    } else if (i27 >= 32) {
                        this.f661D[i7] = b.INVALID_CHAR;
                        z5 = true;
                    } else {
                        this.f661D[i7] = b.INVALID_CHAR;
                        z5 = true;
                    }
                    if (i27 == 35) {
                        this.f661D[i7] = b.INVALID_CHAR;
                        z5 = true;
                    }
                    if (i27 == 36) {
                        this.f661D[i7] = b.INVALID_CHAR;
                        z5 = true;
                    }
                    if (i27 == 64) {
                        this.f661D[i7] = b.INVALID_CHAR;
                        z5 = true;
                    }
                    if (i27 == 92) {
                        this.f661D[i7] = b.INVALID_CHAR;
                        z5 = true;
                    }
                    if (i27 == 94) {
                        this.f661D[i7] = b.INVALID_CHAR;
                        z5 = true;
                    }
                    if (i27 == 96) {
                        this.f661D[i7] = b.INVALID_CHAR;
                        z5 = true;
                    }
                    if (i27 >= 65) {
                        this.f661D[i7] = b.ALPHA_OR_ISO;
                    }
                    if (i27 == 42) {
                        this.f661D[i7] = b.ALPHA_OR_ISO;
                    }
                    if (i27 == 44) {
                        this.f661D[i7] = b.ALPHA_OR_ISO;
                    }
                    if (i27 == 45) {
                        this.f661D[i7] = b.ALPHA_OR_ISO;
                    }
                    if (i27 == 46) {
                        this.f661D[i7] = b.ALPHA_OR_ISO;
                    }
                    if (i27 == 47) {
                        this.f661D[i7] = b.ALPHA_OR_ISO;
                    }
                    if (i27 < 48) {
                    }
                    i7++;
                } else {
                    if (!z5) {
                        throw new H("Invalid characters in input data");
                    }
                    i8 = 0;
                    while (true) {
                        iArr4 = this.f660C;
                        if (i8 < iArr4.length - 1) {
                            bVarArr2 = this.f661D;
                            bVar5 = bVarArr2[i8];
                            bVar6 = b.ISOIEC;
                            if (bVar5 == bVar6) {
                                i26 = i8 + 1;
                                if (iArr4[i26] == -1) {
                                    bVarArr2[i26] = bVar6;
                                }
                            }
                            i8++;
                        } else {
                            i9 = 0;
                            while (true) {
                                iArr5 = this.f660C;
                                if (i9 < iArr5.length - 1) {
                                    bVarArr = this.f661D;
                                    bVar3 = bVarArr[i9];
                                    bVar4 = b.ALPHA_OR_ISO;
                                    if (bVar3 == bVar4) {
                                        i25 = i9 + 1;
                                        if (iArr5[i25] == -1) {
                                            bVarArr[i25] = bVar4;
                                        }
                                    }
                                    i9++;
                                } else {
                                    zL = L();
                                    i10 = 0;
                                    do {
                                        iOrdinal = this.f661D[i10].ordinal();
                                        if (iOrdinal != 0) {
                                            if (i10 != 0) {
                                                i17 = i10 - 1;
                                                if (this.f661D[i17] != b.NUMERIC) {
                                                    i11 = -1;
                                                    if (this.f660C[i17] != -1) {
                                                        this.f678z.append("000");
                                                    }
                                                } else {
                                                    i11 = -1;
                                                }
                                            } else {
                                                i11 = -1;
                                            }
                                            iArr6 = this.f660C;
                                            i12 = iArr6[i10];
                                            if (i12 != i11) {
                                                i13 = i12 - 48;
                                            } else {
                                                i13 = 10;
                                            }
                                            if (i10 < iArr6.length - 1) {
                                                i14 = 10;
                                                i15 = 10;
                                            } else {
                                                i14 = 10;
                                                i15 = 10;
                                            }
                                            if (i13 == i14) {
                                                G2.f.a(this.f678z, (i13 * 11) + i15 + 8, 7);
                                                i10 += 2;
                                            } else {
                                                G2.f.a(this.f678z, (i13 * 11) + i15 + 8, 7);
                                                i10 += 2;
                                            }
                                        } else if (iOrdinal != 1) {
                                            if (i10 != 0) {
                                                this.f678z.append("0000");
                                            } else {
                                                this.f678z.append("0000");
                                            }
                                            i18 = this.f660C[i10];
                                            if (i18 < 48) {
                                            }
                                            i19 = this.f660C[i10];
                                            if (i19 >= 65) {
                                                G2.f.a(this.f678z, i19 - 33, 6);
                                            }
                                            if (this.f660C[i10] == -1) {
                                                this.f678z.append("01111");
                                            }
                                            if (this.f660C[i10] == 42) {
                                                this.f678z.append("111010");
                                            }
                                            if (this.f660C[i10] == 44) {
                                                this.f678z.append("111011");
                                            }
                                            if (this.f660C[i10] == 45) {
                                                this.f678z.append("111100");
                                            }
                                            if (this.f660C[i10] == 46) {
                                                this.f678z.append("111101");
                                            }
                                            if (this.f660C[i10] == 47) {
                                                this.f678z.append("111110");
                                            }
                                            i10++;
                                        } else if (iOrdinal == 2) {
                                            if (i10 != 0) {
                                                this.f678z.append("0000");
                                                this.f678z.append("00100");
                                            } else {
                                                this.f678z.append("0000");
                                                this.f678z.append("00100");
                                            }
                                            i21 = this.f660C[i10];
                                            if (i21 >= 48) {
                                                G2.f.a(this.f678z, i21 - 43, 5);
                                            }
                                            i22 = this.f660C[i10];
                                            if (i22 >= 65) {
                                                G2.f.a(this.f678z, i22 - 1, 7);
                                            }
                                            i23 = this.f660C[i10];
                                            if (i23 >= 97) {
                                                G2.f.a(this.f678z, i23 - 7, 7);
                                            }
                                            if (this.f660C[i10] == -1) {
                                                this.f678z.append("01111");
                                            }
                                            if (this.f660C[i10] == 33) {
                                                this.f678z.append("11101000");
                                            }
                                            if (this.f660C[i10] == 34) {
                                                this.f678z.append("11101001");
                                            }
                                            if (this.f660C[i10] == 37) {
                                                this.f678z.append("11101010");
                                            }
                                            if (this.f660C[i10] == 38) {
                                                this.f678z.append("11101011");
                                            }
                                            if (this.f660C[i10] == 39) {
                                                this.f678z.append("11101100");
                                            }
                                            if (this.f660C[i10] == 40) {
                                                this.f678z.append("11101101");
                                            }
                                            if (this.f660C[i10] == 41) {
                                                this.f678z.append("11101110");
                                            }
                                            if (this.f660C[i10] == 42) {
                                                this.f678z.append("11101111");
                                            }
                                            if (this.f660C[i10] == 43) {
                                                this.f678z.append("11110000");
                                            }
                                            if (this.f660C[i10] == 44) {
                                                this.f678z.append("11110001");
                                            }
                                            if (this.f660C[i10] == 45) {
                                                this.f678z.append("11110010");
                                            }
                                            if (this.f660C[i10] == 46) {
                                                this.f678z.append("11110011");
                                            }
                                            if (this.f660C[i10] == 47) {
                                                this.f678z.append("11110100");
                                            }
                                            if (this.f660C[i10] == 58) {
                                                this.f678z.append("11110101");
                                            }
                                            if (this.f660C[i10] == 59) {
                                                this.f678z.append("11110110");
                                            }
                                            if (this.f660C[i10] == 60) {
                                                this.f678z.append("11110111");
                                            }
                                            if (this.f660C[i10] == 61) {
                                                this.f678z.append("11111000");
                                            }
                                            if (this.f660C[i10] == 62) {
                                                this.f678z.append("11111001");
                                            }
                                            if (this.f660C[i10] == 63) {
                                                this.f678z.append("11111010");
                                            }
                                            if (this.f660C[i10] == 95) {
                                                this.f678z.append("11111011");
                                            }
                                            if (this.f660C[i10] == 32) {
                                                this.f678z.append("11111100");
                                            }
                                            i10++;
                                        }
                                    } while (i10 + (zL ? 1 : 0) < this.f660C.length);
                                    objArr = zL ? 1 : 0;
                                    z4 = false;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            objArr = null;
        }
        if (!N()) {
            return false;
        }
        if (objArr != null) {
            int[] iArr112 = this.f660C;
            i5 = iArr112[iArr112.length - 1];
            if (i5 == -1) {
                this.f678z.append("000001111");
            } else {
                i6 = this.f673P;
                if (i6 >= 4) {
                    G2.f.a(this.f678z, ((i5 - 48) * 11) + 18, 7);
                } else {
                    G2.f.a(this.f678z, ((i5 - 48) * 11) + 18, 7);
                }
            }
        }
        if (this.f678z.length() <= 11805) {
            throw new H("Input too long");
        }
        if (!N()) {
            return false;
        }
        w("Composite Binary Length: " + this.f678z.length());
        Y();
        if (this.f678z.length() < this.f672O) {
            if (z4) {
                this.f678z.append("11111");
            }
            iArr2 = this.f660C;
            if (iArr2.length != 0) {
                this.f678z.append("0000");
            } else {
                this.f678z.append("0000");
            }
            while (true) {
                length = this.f678z.length();
                i4 = this.f672O;
                if (length < i4) {
                    this.f678z.append("00100");
                } else {
                    StringBuilder sb3 = this.f678z;
                    sb3.delete(i4, sb3.length());
                }
            }
        }
        return true;
    }

    private void R() {
        int i3;
        int i4;
        int[] iArr = new int[520];
        int[] iArr2 = new int[35];
        StringBuilder sb = new StringBuilder();
        this.f667J = new int[(this.f678z.length() / 8) + 4];
        int length = this.f678z.length() / 8;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i5 * 8;
            this.f667J[i5] = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (this.f678z.charAt(i6 + i7) == '1') {
                    int[] iArr3 = this.f667J;
                    iArr3[i5] = iArr3[i5] + (128 >> i7);
                }
            }
        }
        this.f665H = 0;
        int[] iArr4 = this.f664G;
        iArr4[0] = 0;
        this.f665H = 1;
        iArr4[1] = 920;
        this.f665H = 1 + 1;
        M(0, length);
        this.f664G[0] = this.f665H;
        int i8 = 1;
        int i9 = 1;
        while (true) {
            i3 = this.f658A;
            if (i8 > i3 + 1) {
                break;
            }
            i9 *= 2;
            i8++;
        }
        switch (i3) {
            case 1:
                i4 = 2;
                break;
            case 2:
                i4 = 6;
                break;
            case 3:
                i4 = 14;
                break;
            case 4:
                i4 = 30;
                break;
            case 5:
                i4 = 62;
                break;
            case 6:
                i4 = 126;
                break;
            case 7:
                i4 = 254;
                break;
            case 8:
                i4 = 510;
                break;
            default:
                i4 = 0;
                break;
        }
        int i10 = this.f665H;
        for (int i11 = 0; i11 < 520; i11++) {
            iArr[i11] = 0;
        }
        u("Composite Codewords: ");
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = i9 - 1;
            int i14 = (this.f664G[i12] + iArr[i13]) % 929;
            while (i13 >= 0) {
                if (i13 == 0) {
                    iArr[i13] = (929 - ((f647V[i4 + i13] * i14) % 929)) % 929;
                } else {
                    iArr[i13] = ((iArr[i13 - 1] + 929) - ((i14 * f647V[i4 + i13]) % 929)) % 929;
                }
                i13--;
            }
            y(this.f664G[i12]);
        }
        v();
        for (int i15 = 0; i15 < i9; i15++) {
            int i16 = iArr[i15];
            if (i16 != 0) {
                iArr[i15] = 929 - i16;
            }
        }
        for (int i17 = i9 - 1; i17 >= 0; i17--) {
            int[] iArr5 = this.f664G;
            int i18 = this.f665H;
            iArr5[i18] = iArr[i17];
            this.f665H = i18 + 1;
        }
        int i19 = this.f665H;
        int i20 = this.f662E;
        int i21 = ((i19 / i20) - 1) / 3;
        int i22 = (this.f658A * 3) + (((i19 / i20) - 1) % 3);
        int i23 = i20 - 1;
        this.f416o = "";
        int i24 = i19 / i20;
        this.f418q = i24;
        this.f417p = new String[i24];
        this.f419r = new int[i24];
        int i25 = 0;
        for (int i26 = 1; i25 <= (this.f665H / this.f662E) - i26; i26 = 1) {
            int i27 = 0;
            while (true) {
                int i28 = this.f662E;
                if (i27 < i28) {
                    int i29 = i27 + 1;
                    iArr2[i29] = this.f664G[(i28 * i25) + i27];
                    i27 = i29;
                } else {
                    int i30 = (i25 / 3) * 30;
                    int i31 = i25 % 3;
                    if (i31 == 0) {
                        iArr2[0] = i30 + i21;
                        iArr2[i28 + 1] = i30 + i23;
                    } else if (i31 == i26) {
                        iArr2[0] = i30 + i22;
                        iArr2[i28 + 1] = i30 + i21;
                    } else if (i31 == 2) {
                        iArr2[0] = i30 + i23;
                        iArr2[i28 + 1] = i30 + i22;
                    }
                    String str = "+*";
                    for (int i32 = 0; i32 <= this.f662E + i26; i32++) {
                        str = (str + f650Y[(i31 != i26 ? i31 != 2 ? 0 : 1858 : 929) + iArr2[i32]]) + "*";
                    }
                    String str2 = str + "-";
                    sb.setLength(0);
                    for (int i33 = 0; i33 < str2.length(); i33++) {
                        sb.append(f652a0[G2.a.c(str2.charAt(i33), f651Z)]);
                    }
                    this.f417p[i25] = Q.a(sb);
                    this.f419r[i25] = 3;
                    i25++;
                }
            }
        }
    }

    private void S(Q q3) {
        q3.B(d());
        q3.G(j());
        q3.F(h());
        q3.H(l());
        q3.I(m());
        q3.J(n());
    }

    private int T() {
        boolean z3 = true;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f670M.length(); i4++) {
            if (this.f670M.charAt(i4) < '0' || this.f670M.charAt(i4) > '9') {
                z3 = false;
            } else if (z3) {
                i3++;
            }
        }
        return i3 <= 7 ? 8 : 13;
    }

    private int U(int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i3) {
            int iZ = Z(i3 - i4, 69);
            int i7 = iZ / 10;
            int i8 = i7 + 1;
            i5 += i8;
            for (int i9 = 0; i9 < i8; i9++) {
                this.f664G[i6 + i9] = 0;
            }
            for (int i10 = 0; i10 < iZ; i10++) {
                if (W(((i4 + iZ) - i10) - 1)) {
                    for (int i11 = 0; i11 < i8; i11++) {
                        int[] iArr = this.f664G;
                        int i12 = i6 + i11;
                        iArr[i12] = iArr[i12] + this.f663F[i10][(i11 + 7) - i8];
                    }
                }
            }
            while (i7 > 0) {
                int[] iArr2 = this.f664G;
                int i13 = i6 + i7;
                int i14 = i13 - 1;
                iArr2[i14] = iArr2[i14] + (iArr2[i13] / 928);
                iArr2[i13] = iArr2[i13] % 928;
                i7--;
            }
            i4 += 69;
            i6 += 7;
        }
        return i5;
    }

    private void V() {
        if (this.f413l.length() > 2990) {
            throw new H("2D component input data too long");
        }
        int[] iArrK = Q.K(this.f413l, StandardCharsets.US_ASCII, new int[0]);
        this.f667J = iArrK;
        if (iArrK == null) {
            throw new H("Invalid characters in input data");
        }
        a aVar = this.f671N;
        this.f668K = aVar;
        a aVar2 = a.CC_C;
        if (aVar == aVar2 && this.f659B != c.CODE_128) {
            throw new H("Invalid mode (CC-C only valid with GS1-128 linear component)");
        }
        switch (this.f659B) {
            case UPCA:
            case CODE_128:
            case DATABAR_14:
            case DATABAR_EXPANDED:
            case DATABAR_EXPANDED_STACK:
                this.f662E = 4;
                break;
            case UPCE:
            case DATABAR_14_STACK:
            case DATABAR_14_STACK_OMNI:
                this.f662E = 2;
                break;
            case EAN:
                if (T() != 8) {
                    this.f662E = 4;
                } else {
                    this.f662E = 3;
                }
                break;
            case DATABAR_LIMITED:
                this.f662E = 3;
                break;
        }
        w("Composite Width: " + this.f662E);
        if (this.f668K == a.CC_A && !Q()) {
            this.f668K = a.CC_B;
        }
        if (this.f668K == a.CC_B && !Q()) {
            if (this.f659B != c.CODE_128) {
                throw new H("Input too long");
            }
            this.f668K = aVar2;
        }
        if (this.f668K == aVar2 && !Q()) {
            throw new H("Input too long");
        }
        int iOrdinal = this.f668K.ordinal();
        if (iOrdinal == 0) {
            O();
            w("Composite Type: CC-A");
        } else if (iOrdinal == 1) {
            P();
            w("Composite Type: CC-B");
        } else if (iOrdinal == 2) {
            R();
            w("Composite Type: CC-C");
        }
        super.A();
    }

    private boolean W(int i3) {
        return ((32768 >> (i3 & 15)) & this.f666I[i3 >> 4]) != 0;
    }

    private void X() {
        int[] iArr = new int[7];
        iArr[6] = 1;
        for (int i3 = 5; i3 >= 0; i3--) {
            iArr[i3] = 0;
        }
        for (int i4 = 0; i4 < 7; i4++) {
            this.f663F[0][i4] = iArr[i4];
        }
        for (int i5 = 1; i5 < 69; i5++) {
            int i6 = 0;
            for (int i7 = 6; i7 >= 1; i7--) {
                i6 = (i6 / 928) + (iArr[i7] * 2);
                int[] iArr2 = this.f663F[i5];
                int i8 = i6 % 928;
                iArr[i7] = i8;
                iArr2[i7] = i8;
            }
            int[] iArr3 = this.f663F[i5];
            int i9 = (iArr[0] * 2) + (i6 / 928);
            iArr[0] = i9;
            iArr3[0] = i9;
        }
    }

    private void Y() {
        u("Composite Binary String: ");
        int i3 = 0;
        for (int i4 = 0; i4 < this.f678z.length(); i4++) {
            int i5 = i4 % 4;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 == 3) {
                            if (this.f678z.charAt(i4) == '1') {
                                i3++;
                            }
                            u(Integer.toHexString(i3));
                            i3 = 0;
                        }
                    } else if (this.f678z.charAt(i4) == '1') {
                        i3 += 2;
                    }
                } else if (this.f678z.charAt(i4) == '1') {
                    i3 += 4;
                }
            } else if (this.f678z.charAt(i4) == '1') {
                i3 += 8;
            }
        }
        if (this.f678z.length() % 4 != 0) {
            u(Integer.toHexString(i3));
        }
        v();
    }

    private int Z(int i3, int i4) {
        return Math.min(i3, i4);
    }

    public void a0(c cVar) {
        this.f659B = cVar;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x025f  */
    /* JADX WARN: Code duplicated, block: B:114:0x0270 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x0259 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x012f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0140  */
    /* JADX WARN: Code duplicated, block: B:58:0x014a  */
    /* JADX WARN: Code duplicated, block: B:59:0x015e  */
    /* JADX WARN: Code duplicated, block: B:61:0x0162  */
    /* JADX WARN: Code duplicated, block: B:65:0x0171 A[LOOP:0: B:63:0x016b->B:65:0x0171, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:80:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:82:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:85:0x01de  */
    /* JADX WARN: Code duplicated, block: B:88:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:91:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:96:0x0220 A[LOOP:2: B:94:0x021a->B:96:0x0220, LOOP_END] */
    @Override // E2.Q
    protected void c() {
        Q q3;
        Q q4;
        Q q5;
        Q q6;
        Q q7;
        Q.a aVar;
        Iterator it;
        Q q8;
        int i3;
        int iCeil;
        double d3;
        double d4;
        int i4;
        int i5;
        c cVar;
        int i6;
        int i7;
        Q q9;
        ArrayList<G2.e> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f674Q = 0;
        if (this.f670M.isEmpty()) {
            throw new H("No linear data set");
        }
        V();
        int i8 = 4;
        int i9 = 3;
        switch (this.f659B) {
            case UPCA:
                U u3 = new U();
                u3.R(U.a.UPCA);
                u3.Q(true);
                Integer num = this.f675R;
                q3 = u3;
                if (num != null) {
                    u3.P(num.intValue());
                    q3 = u3;
                }
                i8 = 6;
                q7 = q3;
                aVar = this.f669L;
                if (aVar != null) {
                    q7.D(aVar);
                }
                S(q7);
                q7.C(this.f670M);
                if (this.f659B == c.CODE_128) {
                    i6 = q7.f421t;
                    this.f674Q = i6;
                    if (this.f668K == a.CC_C) {
                        this.f418q = 0;
                        this.f423v.clear();
                        this.f420s = 0;
                        this.f421t = 0;
                        this.f422u.setLength(0);
                        V();
                    } else {
                        i7 = this.f421t;
                        if (i6 > i7) {
                            i9 = (i6 - i7) / 2;
                        }
                    }
                }
                q8 = q7;
                for (it = this.f423v.iterator(); it.hasNext(); it = it) {
                    G2.e eVar = (G2.e) it.next();
                    double d5 = eVar.f1071a;
                    double d6 = i9;
                    Double.isNaN(d6);
                    arrayList.add(new G2.e(d5 + d6, eVar.f1072b, eVar.f1073c, eVar.f1074d));
                    q8 = q8;
                    i9 = i9;
                }
                Q q10 = q8;
                i3 = this.f676S - 1;
                if (i3 <= 0 && ((cVar = this.f659B) == c.EAN || cVar == c.UPCA || cVar == c.UPCE)) {
                    throw new H("Composite EAN and UPC separator height cannot be changed");
                }
                for (G2.e eVar2 : q10.f423v) {
                    double d7 = eVar2.f1074d;
                    if (i3 > 0 || d7 != 1.0d) {
                        i4 = 0;
                    } else {
                        i4 = i3;
                    }
                    double d8 = i4;
                    Double.isNaN(d8);
                    double d9 = d7 + d8;
                    double d10 = eVar2.f1072b;
                    if (i3 > 0 || d7 == 1.0d) {
                        i5 = 0;
                    } else {
                        i5 = i3;
                    }
                    double d11 = i5;
                    Double.isNaN(d11);
                    double d12 = eVar2.f1071a;
                    double d13 = i8;
                    Double.isNaN(d13);
                    double d14 = d12 + d13;
                    double d15 = this.f420s;
                    Double.isNaN(d15);
                    arrayList.add(new G2.e(d14, d10 + d11 + d15, eVar2.f1073c, d9));
                }
                for (T t3 : q10.f424w) {
                    double d16 = t3.f435a;
                    double d17 = i8;
                    Double.isNaN(d17);
                    double d18 = t3.f436b;
                    double d19 = this.f420s;
                    Double.isNaN(d19);
                    double d20 = d18 + d19;
                    double d21 = i3;
                    Double.isNaN(d21);
                    arrayList2.add(new T(d16 + d17, d20 + d21, t3.f437c, t3.f438d, this.f411j));
                    i8 = i8;
                }
                iCeil = 0;
                for (G2.e eVar3 : arrayList) {
                    d3 = eVar3.f1071a;
                    d4 = eVar3.f1073c;
                    if (d3 + d4 > iCeil) {
                        iCeil = (int) Math.ceil(d3 + d4);
                    }
                }
                this.f423v = arrayList;
                this.f424w = arrayList2;
                this.f420s += q10.f420s + i3;
                this.f421t = iCeil;
                u(q10.e());
                return;
            case UPCE:
                U u4 = new U();
                u4.R(U.a.UPCE);
                u4.Q(true);
                Integer num2 = this.f675R;
                q3 = u4;
                if (num2 != null) {
                    u4.P(num2.intValue());
                    q3 = u4;
                }
                i8 = 6;
                q7 = q3;
                aVar = this.f669L;
                if (aVar != null) {
                    q7.D(aVar);
                }
                S(q7);
                q7.C(this.f670M);
                if (this.f659B == c.CODE_128) {
                    i6 = q7.f421t;
                    this.f674Q = i6;
                    if (this.f668K == a.CC_C) {
                        this.f418q = 0;
                        this.f423v.clear();
                        this.f420s = 0;
                        this.f421t = 0;
                        this.f422u.setLength(0);
                        V();
                    } else {
                        i7 = this.f421t;
                        if (i6 > i7) {
                            i9 = (i6 - i7) / 2;
                        }
                    }
                }
                q8 = q7;
                while (it.hasNext()) {
                    G2.e eVar4 = (G2.e) it.next();
                    double d22 = eVar4.f1071a;
                    double d23 = i9;
                    Double.isNaN(d23);
                    arrayList.add(new G2.e(d22 + d23, eVar4.f1072b, eVar4.f1073c, eVar4.f1074d));
                    q8 = q8;
                    i9 = i9;
                }
                Q q11 = q8;
                i3 = this.f676S - 1;
                if (i3 <= 0) {
                    break;
                }
                while (r6.hasNext()) {
                    double d24 = eVar2.f1074d;
                    if (i3 > 0) {
                        i4 = 0;
                    } else {
                        i4 = 0;
                    }
                    double d25 = i4;
                    Double.isNaN(d25);
                    double d26 = d24 + d25;
                    double d110 = eVar2.f1072b;
                    if (i3 > 0) {
                        i5 = 0;
                    } else {
                        i5 = 0;
                    }
                    double d111 = i5;
                    Double.isNaN(d111);
                    double d112 = eVar2.f1071a;
                    double d113 = i8;
                    Double.isNaN(d113);
                    double d114 = d112 + d113;
                    double d115 = this.f420s;
                    Double.isNaN(d115);
                    arrayList.add(new G2.e(d114, d110 + d111 + d115, eVar2.f1073c, d26));
                }
                while (r6.hasNext()) {
                    double d116 = t3.f435a;
                    double d117 = i8;
                    Double.isNaN(d117);
                    double d118 = t3.f436b;
                    double d119 = this.f420s;
                    Double.isNaN(d119);
                    double d27 = d118 + d119;
                    double d28 = i3;
                    Double.isNaN(d28);
                    arrayList2.add(new T(d116 + d117, d27 + d28, t3.f437c, t3.f438d, this.f411j));
                    i8 = i8;
                }
                iCeil = 0;
                while (r5.hasNext()) {
                    d3 = eVar3.f1071a;
                    d4 = eVar3.f1073c;
                    if (d3 + d4 > iCeil) {
                        iCeil = (int) Math.ceil(d3 + d4);
                    }
                }
                this.f423v = arrayList;
                this.f424w = arrayList2;
                this.f420s += q11.f420s + i3;
                this.f421t = iCeil;
                u(q11.e());
                return;
            case EAN:
                C0205v c0205v = new C0205v();
                if (T() == 8) {
                    c0205v.S(C0205v.a.EAN8);
                    i8 = this.f668K != a.CC_A ? 14 : 4;
                    i9 = 0;
                } else {
                    c0205v.S(C0205v.a.EAN13);
                    i8 = 6;
                }
                c0205v.R(true);
                Integer num3 = this.f675R;
                q7 = c0205v;
                if (num3 != null) {
                    c0205v.Q(num3.intValue());
                    q7 = c0205v;
                }
                aVar = this.f669L;
                if (aVar != null) {
                    q7.D(aVar);
                }
                S(q7);
                q7.C(this.f670M);
                if (this.f659B == c.CODE_128) {
                    i6 = q7.f421t;
                    this.f674Q = i6;
                    if (this.f668K == a.CC_C) {
                        this.f418q = 0;
                        this.f423v.clear();
                        this.f420s = 0;
                        this.f421t = 0;
                        this.f422u.setLength(0);
                        V();
                    } else {
                        i7 = this.f421t;
                        if (i6 > i7) {
                            i9 = (i6 - i7) / 2;
                        }
                    }
                }
                q8 = q7;
                while (it.hasNext()) {
                    G2.e eVar5 = (G2.e) it.next();
                    double d29 = eVar5.f1071a;
                    double d210 = i9;
                    Double.isNaN(d210);
                    arrayList.add(new G2.e(d29 + d210, eVar5.f1072b, eVar5.f1073c, eVar5.f1074d));
                    q8 = q8;
                    i9 = i9;
                }
                Q q12 = q8;
                i3 = this.f676S - 1;
                if (i3 <= 0) {
                    break;
                }
                while (r6.hasNext()) {
                    double d211 = eVar2.f1074d;
                    if (i3 > 0) {
                        i4 = 0;
                    } else {
                        i4 = 0;
                    }
                    double d212 = i4;
                    Double.isNaN(d212);
                    double d213 = d211 + d212;
                    double d1110 = eVar2.f1072b;
                    if (i3 > 0) {
                        i5 = 0;
                    } else {
                        i5 = 0;
                    }
                    double d1111 = i5;
                    Double.isNaN(d1111);
                    double d1112 = eVar2.f1071a;
                    double d1113 = i8;
                    Double.isNaN(d1113);
                    double d1114 = d1112 + d1113;
                    double d1115 = this.f420s;
                    Double.isNaN(d1115);
                    arrayList.add(new G2.e(d1114, d1110 + d1111 + d1115, eVar2.f1073c, d213));
                }
                while (r6.hasNext()) {
                    double d1116 = t3.f435a;
                    double d1117 = i8;
                    Double.isNaN(d1117);
                    double d1118 = t3.f436b;
                    double d1119 = this.f420s;
                    Double.isNaN(d1119);
                    double d214 = d1118 + d1119;
                    double d215 = i3;
                    Double.isNaN(d215);
                    arrayList2.add(new T(d1116 + d1117, d214 + d215, t3.f437c, t3.f438d, this.f411j));
                    i8 = i8;
                }
                iCeil = 0;
                while (r5.hasNext()) {
                    d3 = eVar3.f1071a;
                    d4 = eVar3.f1073c;
                    if (d3 + d4 > iCeil) {
                        iCeil = (int) Math.ceil(d3 + d4);
                    }
                }
                this.f423v = arrayList;
                this.f424w = arrayList2;
                this.f420s += q12.f420s + i3;
                this.f421t = iCeil;
                u(q12.e());
                return;
            case CODE_128:
                C0192h c0192h = new C0192h();
                int iOrdinal = this.f668K.ordinal();
                if (iOrdinal == 0) {
                    c0192h.R();
                } else {
                    if (iOrdinal != 1) {
                        if (iOrdinal == 2) {
                            c0192h.T();
                            i8 = 7;
                        }
                        c0192h.D(Q.a.GS1);
                        q4 = c0192h;
                        i9 = 0;
                        q7 = q4;
                        aVar = this.f669L;
                        if (aVar != null) {
                            q7.D(aVar);
                        }
                        S(q7);
                        q7.C(this.f670M);
                        if (this.f659B == c.CODE_128) {
                            i6 = q7.f421t;
                            this.f674Q = i6;
                            if (this.f668K == a.CC_C) {
                                this.f418q = 0;
                                this.f423v.clear();
                                this.f420s = 0;
                                this.f421t = 0;
                                this.f422u.setLength(0);
                                V();
                            } else {
                                i7 = this.f421t;
                                if (i6 > i7) {
                                    i9 = (i6 - i7) / 2;
                                }
                            }
                        }
                        q8 = q7;
                        while (it.hasNext()) {
                            G2.e eVar6 = (G2.e) it.next();
                            double d216 = eVar6.f1071a;
                            double d217 = i9;
                            Double.isNaN(d217);
                            arrayList.add(new G2.e(d216 + d217, eVar6.f1072b, eVar6.f1073c, eVar6.f1074d));
                            q8 = q8;
                            i9 = i9;
                        }
                        Q q13 = q8;
                        i3 = this.f676S - 1;
                        if (i3 <= 0) {
                            break;
                        }
                        while (r6.hasNext()) {
                            double d218 = eVar2.f1074d;
                            if (i3 > 0) {
                                i4 = 0;
                            } else {
                                i4 = 0;
                            }
                            double d219 = i4;
                            Double.isNaN(d219);
                            double d2110 = d218 + d219;
                            double d11110 = eVar2.f1072b;
                            if (i3 > 0) {
                                i5 = 0;
                            } else {
                                i5 = 0;
                            }
                            double d11111 = i5;
                            Double.isNaN(d11111);
                            double d11112 = eVar2.f1071a;
                            double d11113 = i8;
                            Double.isNaN(d11113);
                            double d11114 = d11112 + d11113;
                            double d11115 = this.f420s;
                            Double.isNaN(d11115);
                            arrayList.add(new G2.e(d11114, d11110 + d11111 + d11115, eVar2.f1073c, d2110));
                        }
                        while (r6.hasNext()) {
                            double d11116 = t3.f435a;
                            double d11117 = i8;
                            Double.isNaN(d11117);
                            double d11118 = t3.f436b;
                            double d11119 = this.f420s;
                            Double.isNaN(d11119);
                            double d2111 = d11118 + d11119;
                            double d2112 = i3;
                            Double.isNaN(d2112);
                            arrayList2.add(new T(d11116 + d11117, d2111 + d2112, t3.f437c, t3.f438d, this.f411j));
                            i8 = i8;
                        }
                        iCeil = 0;
                        while (r5.hasNext()) {
                            d3 = eVar3.f1071a;
                            d4 = eVar3.f1073c;
                            if (d3 + d4 > iCeil) {
                                iCeil = (int) Math.ceil(d3 + d4);
                            }
                        }
                        this.f423v = arrayList;
                        this.f424w = arrayList2;
                        this.f420s += q13.f420s + i3;
                        this.f421t = iCeil;
                        u(q13.e());
                        return;
                    }
                    c0192h.S();
                }
                i8 = 0;
                c0192h.D(Q.a.GS1);
                q4 = c0192h;
                i9 = 0;
                q7 = q4;
                aVar = this.f669L;
                if (aVar != null) {
                    q7.D(aVar);
                }
                S(q7);
                q7.C(this.f670M);
                if (this.f659B == c.CODE_128) {
                    i6 = q7.f421t;
                    this.f674Q = i6;
                    if (this.f668K == a.CC_C) {
                        this.f418q = 0;
                        this.f423v.clear();
                        this.f420s = 0;
                        this.f421t = 0;
                        this.f422u.setLength(0);
                        V();
                    } else {
                        i7 = this.f421t;
                        if (i6 > i7) {
                            i9 = (i6 - i7) / 2;
                        }
                    }
                }
                q8 = q7;
                while (it.hasNext()) {
                    G2.e eVar7 = (G2.e) it.next();
                    double d2113 = eVar7.f1071a;
                    double d2114 = i9;
                    Double.isNaN(d2114);
                    arrayList.add(new G2.e(d2113 + d2114, eVar7.f1072b, eVar7.f1073c, eVar7.f1074d));
                    q8 = q8;
                    i9 = i9;
                }
                Q q14 = q8;
                i3 = this.f676S - 1;
                if (i3 <= 0) {
                    break;
                }
                while (r6.hasNext()) {
                    double d2115 = eVar2.f1074d;
                    if (i3 > 0) {
                        i4 = 0;
                    } else {
                        i4 = 0;
                    }
                    double d2116 = i4;
                    Double.isNaN(d2116);
                    double d2117 = d2115 + d2116;
                    double d111110 = eVar2.f1072b;
                    if (i3 > 0) {
                        i5 = 0;
                    } else {
                        i5 = 0;
                    }
                    double d111111 = i5;
                    Double.isNaN(d111111);
                    double d111112 = eVar2.f1071a;
                    double d111113 = i8;
                    Double.isNaN(d111113);
                    double d111114 = d111112 + d111113;
                    double d111115 = this.f420s;
                    Double.isNaN(d111115);
                    arrayList.add(new G2.e(d111114, d111110 + d111111 + d111115, eVar2.f1073c, d2117));
                }
                while (r6.hasNext()) {
                    double d111116 = t3.f435a;
                    double d111117 = i8;
                    Double.isNaN(d111117);
                    double d111118 = t3.f436b;
                    double d111119 = this.f420s;
                    Double.isNaN(d111119);
                    double d2118 = d111118 + d111119;
                    double d2119 = i3;
                    Double.isNaN(d2119);
                    arrayList2.add(new T(d111116 + d111117, d2118 + d2119, t3.f437c, t3.f438d, this.f411j));
                    i8 = i8;
                }
                iCeil = 0;
                while (r5.hasNext()) {
                    d3 = eVar3.f1071a;
                    d4 = eVar3.f1073c;
                    if (d3 + d4 > iCeil) {
                        iCeil = (int) Math.ceil(d3 + d4);
                    }
                }
                this.f423v = arrayList;
                this.f424w = arrayList2;
                this.f420s += q14.f420s + i3;
                this.f421t = iCeil;
                u(q14.e());
                return;
            case DATABAR_14:
                r rVar = new r();
                rVar.L(true);
                rVar.M(r.a.LINEAR);
                q4 = rVar;
                i9 = 0;
                q7 = q4;
                aVar = this.f669L;
                if (aVar != null) {
                    q7.D(aVar);
                }
                S(q7);
                q7.C(this.f670M);
                if (this.f659B == c.CODE_128) {
                    i6 = q7.f421t;
                    this.f674Q = i6;
                    if (this.f668K == a.CC_C) {
                        this.f418q = 0;
                        this.f423v.clear();
                        this.f420s = 0;
                        this.f421t = 0;
                        this.f422u.setLength(0);
                        V();
                    } else {
                        i7 = this.f421t;
                        if (i6 > i7) {
                            i9 = (i6 - i7) / 2;
                        }
                    }
                }
                q8 = q7;
                while (it.hasNext()) {
                    G2.e eVar8 = (G2.e) it.next();
                    double d21110 = eVar8.f1071a;
                    double d21111 = i9;
                    Double.isNaN(d21111);
                    arrayList.add(new G2.e(d21110 + d21111, eVar8.f1072b, eVar8.f1073c, eVar8.f1074d));
                    q8 = q8;
                    i9 = i9;
                }
                Q q15 = q8;
                i3 = this.f676S - 1;
                if (i3 <= 0) {
                    break;
                }
                while (r6.hasNext()) {
                    double d21112 = eVar2.f1074d;
                    if (i3 > 0) {
                        i4 = 0;
                    } else {
                        i4 = 0;
                    }
                    double d21113 = i4;
                    Double.isNaN(d21113);
                    double d21114 = d21112 + d21113;
                    double d1111110 = eVar2.f1072b;
                    if (i3 > 0) {
                        i5 = 0;
                    } else {
                        i5 = 0;
                    }
                    double d1111111 = i5;
                    Double.isNaN(d1111111);
                    double d1111112 = eVar2.f1071a;
                    double d1111113 = i8;
                    Double.isNaN(d1111113);
                    double d1111114 = d1111112 + d1111113;
                    double d1111115 = this.f420s;
                    Double.isNaN(d1111115);
                    arrayList.add(new G2.e(d1111114, d1111110 + d1111111 + d1111115, eVar2.f1073c, d21114));
                }
                while (r6.hasNext()) {
                    double d1111116 = t3.f435a;
                    double d1111117 = i8;
                    Double.isNaN(d1111117);
                    double d1111118 = t3.f436b;
                    double d1111119 = this.f420s;
                    Double.isNaN(d1111119);
                    double d21115 = d1111118 + d1111119;
                    double d21116 = i3;
                    Double.isNaN(d21116);
                    arrayList2.add(new T(d1111116 + d1111117, d21115 + d21116, t3.f437c, t3.f438d, this.f411j));
                    i8 = i8;
                }
                iCeil = 0;
                while (r5.hasNext()) {
                    d3 = eVar3.f1071a;
                    d4 = eVar3.f1073c;
                    if (d3 + d4 > iCeil) {
                        iCeil = (int) Math.ceil(d3 + d4);
                    }
                }
                this.f423v = arrayList;
                this.f424w = arrayList2;
                this.f420s += q15.f420s + i3;
                this.f421t = iCeil;
                u(q15.e());
                return;
            case DATABAR_14_STACK:
                r rVar2 = new r();
                rVar2.L(true);
                rVar2.M(r.a.STACKED);
                rVar2.N(this.f676S);
                q5 = rVar2;
                i8 = 0;
                q6 = q5;
                i9 = 1;
                q7 = q6;
                aVar = this.f669L;
                if (aVar != null) {
                    q7.D(aVar);
                }
                S(q7);
                q7.C(this.f670M);
                if (this.f659B == c.CODE_128) {
                    i6 = q7.f421t;
                    this.f674Q = i6;
                    if (this.f668K == a.CC_C) {
                        this.f418q = 0;
                        this.f423v.clear();
                        this.f420s = 0;
                        this.f421t = 0;
                        this.f422u.setLength(0);
                        V();
                    } else {
                        i7 = this.f421t;
                        if (i6 > i7) {
                            i9 = (i6 - i7) / 2;
                        }
                    }
                }
                q8 = q7;
                while (it.hasNext()) {
                    G2.e eVar9 = (G2.e) it.next();
                    double d21117 = eVar9.f1071a;
                    double d21118 = i9;
                    Double.isNaN(d21118);
                    arrayList.add(new G2.e(d21117 + d21118, eVar9.f1072b, eVar9.f1073c, eVar9.f1074d));
                    q8 = q8;
                    i9 = i9;
                }
                Q q16 = q8;
                i3 = this.f676S - 1;
                if (i3 <= 0) {
                    break;
                }
                while (r6.hasNext()) {
                    double d21119 = eVar2.f1074d;
                    if (i3 > 0) {
                        i4 = 0;
                    } else {
                        i4 = 0;
                    }
                    double d211110 = i4;
                    Double.isNaN(d211110);
                    double d211111 = d21119 + d211110;
                    double d11111110 = eVar2.f1072b;
                    if (i3 > 0) {
                        i5 = 0;
                    } else {
                        i5 = 0;
                    }
                    double d11111111 = i5;
                    Double.isNaN(d11111111);
                    double d11111112 = eVar2.f1071a;
                    double d11111113 = i8;
                    Double.isNaN(d11111113);
                    double d11111114 = d11111112 + d11111113;
                    double d11111115 = this.f420s;
                    Double.isNaN(d11111115);
                    arrayList.add(new G2.e(d11111114, d11111110 + d11111111 + d11111115, eVar2.f1073c, d211111));
                }
                while (r6.hasNext()) {
                    double d11111116 = t3.f435a;
                    double d11111117 = i8;
                    Double.isNaN(d11111117);
                    double d11111118 = t3.f436b;
                    double d11111119 = this.f420s;
                    Double.isNaN(d11111119);
                    double d211112 = d11111118 + d11111119;
                    double d211113 = i3;
                    Double.isNaN(d211113);
                    arrayList2.add(new T(d11111116 + d11111117, d211112 + d211113, t3.f437c, t3.f438d, this.f411j));
                    i8 = i8;
                }
                iCeil = 0;
                while (r5.hasNext()) {
                    d3 = eVar3.f1071a;
                    d4 = eVar3.f1073c;
                    if (d3 + d4 > iCeil) {
                        iCeil = (int) Math.ceil(d3 + d4);
                    }
                }
                this.f423v = arrayList;
                this.f424w = arrayList2;
                this.f420s += q16.f420s + i3;
                this.f421t = iCeil;
                u(q16.e());
                return;
            case DATABAR_14_STACK_OMNI:
                r rVar3 = new r();
                rVar3.L(true);
                rVar3.M(r.a.OMNI);
                rVar3.N(this.f676S);
                q5 = rVar3;
                i8 = 0;
                q6 = q5;
                i9 = 1;
                q7 = q6;
                aVar = this.f669L;
                if (aVar != null) {
                    q7.D(aVar);
                }
                S(q7);
                q7.C(this.f670M);
                if (this.f659B == c.CODE_128) {
                    i6 = q7.f421t;
                    this.f674Q = i6;
                    if (this.f668K == a.CC_C) {
                        this.f418q = 0;
                        this.f423v.clear();
                        this.f420s = 0;
                        this.f421t = 0;
                        this.f422u.setLength(0);
                        V();
                    } else {
                        i7 = this.f421t;
                        if (i6 > i7) {
                            i9 = (i6 - i7) / 2;
                        }
                    }
                }
                q8 = q7;
                while (it.hasNext()) {
                    G2.e eVar10 = (G2.e) it.next();
                    double d211114 = eVar10.f1071a;
                    double d211115 = i9;
                    Double.isNaN(d211115);
                    arrayList.add(new G2.e(d211114 + d211115, eVar10.f1072b, eVar10.f1073c, eVar10.f1074d));
                    q8 = q8;
                    i9 = i9;
                }
                Q q17 = q8;
                i3 = this.f676S - 1;
                if (i3 <= 0) {
                    break;
                }
                while (r6.hasNext()) {
                    double d211116 = eVar2.f1074d;
                    if (i3 > 0) {
                        i4 = 0;
                    } else {
                        i4 = 0;
                    }
                    double d211117 = i4;
                    Double.isNaN(d211117);
                    double d211118 = d211116 + d211117;
                    double d111111110 = eVar2.f1072b;
                    if (i3 > 0) {
                        i5 = 0;
                    } else {
                        i5 = 0;
                    }
                    double d111111111 = i5;
                    Double.isNaN(d111111111);
                    double d111111112 = eVar2.f1071a;
                    double d111111113 = i8;
                    Double.isNaN(d111111113);
                    double d111111114 = d111111112 + d111111113;
                    double d111111115 = this.f420s;
                    Double.isNaN(d111111115);
                    arrayList.add(new G2.e(d111111114, d111111110 + d111111111 + d111111115, eVar2.f1073c, d211118));
                }
                while (r6.hasNext()) {
                    double d111111116 = t3.f435a;
                    double d111111117 = i8;
                    Double.isNaN(d111111117);
                    double d111111118 = t3.f436b;
                    double d111111119 = this.f420s;
                    Double.isNaN(d111111119);
                    double d211119 = d111111118 + d111111119;
                    double d2111110 = i3;
                    Double.isNaN(d2111110);
                    arrayList2.add(new T(d111111116 + d111111117, d211119 + d2111110, t3.f437c, t3.f438d, this.f411j));
                    i8 = i8;
                }
                iCeil = 0;
                while (r5.hasNext()) {
                    d3 = eVar3.f1071a;
                    d4 = eVar3.f1073c;
                    if (d3 + d4 > iCeil) {
                        iCeil = (int) Math.ceil(d3 + d4);
                    }
                }
                this.f423v = arrayList;
                this.f424w = arrayList2;
                this.f420s += q17.f420s + i3;
                this.f421t = iCeil;
                u(q17.e());
                return;
            case DATABAR_LIMITED:
                C0203t c0203t = new C0203t();
                c0203t.N();
                q5 = c0203t;
                if (this.f668K == a.CC_A) {
                    i8 = 0;
                    q6 = q5;
                } else {
                    i8 = 10;
                    q6 = c0203t;
                }
                i9 = 1;
                q7 = q6;
                aVar = this.f669L;
                if (aVar != null) {
                    q7.D(aVar);
                }
                S(q7);
                q7.C(this.f670M);
                if (this.f659B == c.CODE_128) {
                    i6 = q7.f421t;
                    this.f674Q = i6;
                    if (this.f668K == a.CC_C) {
                        this.f418q = 0;
                        this.f423v.clear();
                        this.f420s = 0;
                        this.f421t = 0;
                        this.f422u.setLength(0);
                        V();
                    } else {
                        i7 = this.f421t;
                        if (i6 > i7) {
                            i9 = (i6 - i7) / 2;
                        }
                    }
                }
                q8 = q7;
                while (it.hasNext()) {
                    G2.e eVar11 = (G2.e) it.next();
                    double d2111111 = eVar11.f1071a;
                    double d2111112 = i9;
                    Double.isNaN(d2111112);
                    arrayList.add(new G2.e(d2111111 + d2111112, eVar11.f1072b, eVar11.f1073c, eVar11.f1074d));
                    q8 = q8;
                    i9 = i9;
                }
                Q q18 = q8;
                i3 = this.f676S - 1;
                if (i3 <= 0) {
                    break;
                }
                while (r6.hasNext()) {
                    double d2111113 = eVar2.f1074d;
                    if (i3 > 0) {
                        i4 = 0;
                    } else {
                        i4 = 0;
                    }
                    double d2111114 = i4;
                    Double.isNaN(d2111114);
                    double d2111115 = d2111113 + d2111114;
                    double d1111111110 = eVar2.f1072b;
                    if (i3 > 0) {
                        i5 = 0;
                    } else {
                        i5 = 0;
                    }
                    double d1111111111 = i5;
                    Double.isNaN(d1111111111);
                    double d1111111112 = eVar2.f1071a;
                    double d1111111113 = i8;
                    Double.isNaN(d1111111113);
                    double d1111111114 = d1111111112 + d1111111113;
                    double d1111111115 = this.f420s;
                    Double.isNaN(d1111111115);
                    arrayList.add(new G2.e(d1111111114, d1111111110 + d1111111111 + d1111111115, eVar2.f1073c, d2111115));
                }
                while (r6.hasNext()) {
                    double d1111111116 = t3.f435a;
                    double d1111111117 = i8;
                    Double.isNaN(d1111111117);
                    double d1111111118 = t3.f436b;
                    double d1111111119 = this.f420s;
                    Double.isNaN(d1111111119);
                    double d2111116 = d1111111118 + d1111111119;
                    double d2111117 = i3;
                    Double.isNaN(d2111117);
                    arrayList2.add(new T(d1111111116 + d1111111117, d2111116 + d2111117, t3.f437c, t3.f438d, this.f411j));
                    i8 = i8;
                }
                iCeil = 0;
                while (r5.hasNext()) {
                    d3 = eVar3.f1071a;
                    d4 = eVar3.f1073c;
                    if (d3 + d4 > iCeil) {
                        iCeil = (int) Math.ceil(d3 + d4);
                    }
                }
                this.f423v = arrayList;
                this.f424w = arrayList2;
                this.f420s += q18.f420s + i3;
                this.f421t = iCeil;
                u(q18.e());
                return;
            case DATABAR_EXPANDED:
                C0202s c0202s = new C0202s();
                c0202s.R(true);
                c0202s.T(false);
                q9 = c0202s;
                i8 = 0;
                i9 = 2;
                q7 = q9;
                aVar = this.f669L;
                if (aVar != null) {
                    q7.D(aVar);
                }
                S(q7);
                q7.C(this.f670M);
                if (this.f659B == c.CODE_128) {
                    i6 = q7.f421t;
                    this.f674Q = i6;
                    if (this.f668K == a.CC_C) {
                        this.f418q = 0;
                        this.f423v.clear();
                        this.f420s = 0;
                        this.f421t = 0;
                        this.f422u.setLength(0);
                        V();
                    } else {
                        i7 = this.f421t;
                        if (i6 > i7) {
                            i9 = (i6 - i7) / 2;
                        }
                    }
                }
                q8 = q7;
                while (it.hasNext()) {
                    G2.e eVar12 = (G2.e) it.next();
                    double d2111118 = eVar12.f1071a;
                    double d2111119 = i9;
                    Double.isNaN(d2111119);
                    arrayList.add(new G2.e(d2111118 + d2111119, eVar12.f1072b, eVar12.f1073c, eVar12.f1074d));
                    q8 = q8;
                    i9 = i9;
                }
                Q q19 = q8;
                i3 = this.f676S - 1;
                if (i3 <= 0) {
                    break;
                }
                while (r6.hasNext()) {
                    double d21111110 = eVar2.f1074d;
                    if (i3 > 0) {
                        i4 = 0;
                    } else {
                        i4 = 0;
                    }
                    double d21111111 = i4;
                    Double.isNaN(d21111111);
                    double d21111112 = d21111110 + d21111111;
                    double d11111111110 = eVar2.f1072b;
                    if (i3 > 0) {
                        i5 = 0;
                    } else {
                        i5 = 0;
                    }
                    double d11111111111 = i5;
                    Double.isNaN(d11111111111);
                    double d11111111112 = eVar2.f1071a;
                    double d11111111113 = i8;
                    Double.isNaN(d11111111113);
                    double d11111111114 = d11111111112 + d11111111113;
                    double d11111111115 = this.f420s;
                    Double.isNaN(d11111111115);
                    arrayList.add(new G2.e(d11111111114, d11111111110 + d11111111111 + d11111111115, eVar2.f1073c, d21111112));
                }
                while (r6.hasNext()) {
                    double d11111111116 = t3.f435a;
                    double d11111111117 = i8;
                    Double.isNaN(d11111111117);
                    double d11111111118 = t3.f436b;
                    double d11111111119 = this.f420s;
                    Double.isNaN(d11111111119);
                    double d21111113 = d11111111118 + d11111111119;
                    double d21111114 = i3;
                    Double.isNaN(d21111114);
                    arrayList2.add(new T(d11111111116 + d11111111117, d21111113 + d21111114, t3.f437c, t3.f438d, this.f411j));
                    i8 = i8;
                }
                iCeil = 0;
                while (r5.hasNext()) {
                    d3 = eVar3.f1071a;
                    d4 = eVar3.f1073c;
                    if (d3 + d4 > iCeil) {
                        iCeil = (int) Math.ceil(d3 + d4);
                    }
                }
                this.f423v = arrayList;
                this.f424w = arrayList2;
                this.f420s += q19.f420s + i3;
                this.f421t = iCeil;
                u(q19.e());
                return;
            case DATABAR_EXPANDED_STACK:
                C0202s c0202s2 = new C0202s();
                c0202s2.R(true);
                c0202s2.T(true);
                Integer num4 = this.f677T;
                q9 = c0202s2;
                if (num4 != null) {
                    c0202s2.S(num4.intValue());
                    q9 = c0202s2;
                }
                i8 = 0;
                i9 = 2;
                q7 = q9;
                aVar = this.f669L;
                if (aVar != null) {
                    q7.D(aVar);
                }
                S(q7);
                q7.C(this.f670M);
                if (this.f659B == c.CODE_128) {
                    i6 = q7.f421t;
                    this.f674Q = i6;
                    if (this.f668K == a.CC_C) {
                        this.f418q = 0;
                        this.f423v.clear();
                        this.f420s = 0;
                        this.f421t = 0;
                        this.f422u.setLength(0);
                        V();
                    } else {
                        i7 = this.f421t;
                        if (i6 > i7) {
                            i9 = (i6 - i7) / 2;
                        }
                    }
                }
                q8 = q7;
                while (it.hasNext()) {
                    G2.e eVar13 = (G2.e) it.next();
                    double d21111115 = eVar13.f1071a;
                    double d21111116 = i9;
                    Double.isNaN(d21111116);
                    arrayList.add(new G2.e(d21111115 + d21111116, eVar13.f1072b, eVar13.f1073c, eVar13.f1074d));
                    q8 = q8;
                    i9 = i9;
                }
                Q q110 = q8;
                i3 = this.f676S - 1;
                if (i3 <= 0) {
                    break;
                }
                while (r6.hasNext()) {
                    double d21111117 = eVar2.f1074d;
                    if (i3 > 0) {
                        i4 = 0;
                    } else {
                        i4 = 0;
                    }
                    double d21111118 = i4;
                    Double.isNaN(d21111118);
                    double d21111119 = d21111117 + d21111118;
                    double d111111111110 = eVar2.f1072b;
                    if (i3 > 0) {
                        i5 = 0;
                    } else {
                        i5 = 0;
                    }
                    double d111111111111 = i5;
                    Double.isNaN(d111111111111);
                    double d111111111112 = eVar2.f1071a;
                    double d111111111113 = i8;
                    Double.isNaN(d111111111113);
                    double d111111111114 = d111111111112 + d111111111113;
                    double d111111111115 = this.f420s;
                    Double.isNaN(d111111111115);
                    arrayList.add(new G2.e(d111111111114, d111111111110 + d111111111111 + d111111111115, eVar2.f1073c, d21111119));
                }
                while (r6.hasNext()) {
                    double d111111111116 = t3.f435a;
                    double d111111111117 = i8;
                    Double.isNaN(d111111111117);
                    double d111111111118 = t3.f436b;
                    double d111111111119 = this.f420s;
                    Double.isNaN(d111111111119);
                    double d211111110 = d111111111118 + d111111111119;
                    double d211111111 = i3;
                    Double.isNaN(d211111111);
                    arrayList2.add(new T(d111111111116 + d111111111117, d211111110 + d211111111, t3.f437c, t3.f438d, this.f411j));
                    i8 = i8;
                }
                iCeil = 0;
                while (r5.hasNext()) {
                    d3 = eVar3.f1071a;
                    d4 = eVar3.f1073c;
                    if (d3 + d4 > iCeil) {
                        iCeil = (int) Math.ceil(d3 + d4);
                    }
                }
                this.f423v = arrayList;
                this.f424w = arrayList2;
                this.f420s += q110.f420s + i3;
                this.f421t = iCeil;
                u(q110.e());
                return;
            default:
                throw new H("Linear symbol not recognised");
        }
    }

    @Override // E2.Q
    protected boolean s() {
        return true;
    }

    @Override // E2.Q
    protected void A() {
    }
}
