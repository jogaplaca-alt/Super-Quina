package E2;

import com.hoho.android.usbserial.driver.UsbId;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class I extends Q {

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    private static final int[] f326I = {27, 917, 522, 568, 723, 809, 237, 308, 436, 284, 646, 653, 428, 379, 274, 562, 232, 755, 599, 524, 801, 132, 295, 116, 442, 428, 295, 42, 176, 65, 361, 575, 922, 525, 176, 586, 640, 321, 536, 742, 677, 742, 687, 284, 193, 517, 273, 494, 263, 147, 593, 800, 571, 320, 803, 133, 231, 390, 685, 330, 63, 410, 539, 422, 6, 93, 862, 771, 453, 106, 610, 287, 107, 505, 733, 877, 381, 612, 723, 476, 462, 172, 430, 609, 858, 822, 543, 376, 511, 400, 672, 762, 283, 184, 440, 35, 519, 31, 460, 594, 225, 535, 517, 352, 605, 158, 651, 201, 488, 502, 648, 733, 717, 83, 404, 97, 280, 771, 840, 629, 4, 381, 843, 623, 264, 543, 521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, 400, 925, 749, 415, 822, 93, 217, 208, 928, 244, 583, 620, 246, 148, 447, 631, 292, 908, 490, 704, UsbId.ARM_MBED, 258, 457, 907, 594, 723, 674, 292, 272, 96, 684, 432, 686, 606, 860, 569, 193, 219, 129, 186, 236, 287, 192, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, 156, 732, 95, 270, 447, 90, 507, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, 262, 380, 602, 754, 336, 89, 614, 87, 432, 670, 616, 157, 374, 242, 726, 600, 269, 375, 898, 845, 454, 354, 130, 814, 587, 804, 34, 211, 330, 539, 297, 827, 865, 37, 517, 834, 315, 550, 86, 801, 4, 108, 539, 524, 894, 75, 766, 882, 857, 74, 204, 82, 586, 708, 250, 905, 786, 138, 720, 858, 194, 311, 913, 275, 190, 375, 850, 438, 733, 194, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, 204, 796, 605, 540, 913, 801, 700, 799, 137, 439, 418, 592, 668, 353, 859, 370, 694, 325, 240, 216, 257, 284, 549, 209, 884, 315, 70, 329, 793, 490, 274, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, 307, 291, 803, 712, 19, 358, 399, 908, 103, 511, 51, 8, 517, 225, 289, 470, 637, 731, 66, 255, 917, 269, 463, 830, 730, 433, 848, 585, 136, 538, 906, 90, 2, 290, 743, 199, 655, 903, 329, 49, 802, 580, 355, 588, 188, 462, 10, 134, 628, 320, 479, 130, 739, 71, 263, 318, 374, 601, 192, 605, 142, 673, 687, 234, 722, 384, 177, 752, 607, 640, 455, 193, 689, 707, 805, 641, 48, 60, 732, 621, 895, 544, 261, 852, 655, 309, 697, 755, 756, 60, 231, 773, 434, 421, 726, 528, 503, 118, 49, 795, 32, 144, 500, 238, 836, 394, 280, 566, 319, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, 609, 441, 180, 791, 893, 754, 605, 383, 228, 749, 760, 213, 54, 297, 134, 54, 834, 299, 922, 191, 910, 532, 609, 829, 189, 20, 167, 29, 872, 449, 83, 402, 41, 656, 505, 579, 481, 173, 404, 251, 688, 95, 497, 555, 642, 543, 307, 159, 924, 558, 648, 55, 497, 10, 352, 77, 373, 504, 35, 599, 428, 207, 409, 574, 118, 498, 285, 380, 350, 492, 197, 265, 920, 155, 914, 299, 229, 643, 294, 871, 306, 88, 87, 193, 352, 781, 846, 75, 327, 520, 435, 543, 203, 666, 249, 346, 781, 621, 640, 268, 794, 534, 539, 781, 408, 390, 644, 102, 476, 499, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, 272, 383, 800, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, 290, 204, 681, 407, 855, 85, 99, 62, 482, 180, 20, 297, 451, 593, 913, 142, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, 513, 192, UsbId.ARM_MBED, 258, 240, 518, 794, 395, 768, 848, 51, 610, 384, 168, 190, 826, 328, 596, 786, 303, 570, 381, 415, 641, 156, 237, 151, 429, 531, 207, 676, 710, 89, 168, 304, 402, 40, 708, 575, 162, 864, 229, 65, 861, 841, 512, 164, 477, 221, 92, 358, 785, 288, 357, 850, 836, 827, 736, 707, 94, 8, 494, 114, 521, 2, 499, 851, 543, 152, 729, 771, 95, 248, 361, 578, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, 902, 452, 167, 342, 244, 173, 35, 463, 651, 51, 699, 591, 452, 578, 37, 124, 298, 332, 552, 43, 427, 119, 662, 777, 475, 850, 764, 364, 578, 911, 283, 711, 472, 420, 245, 288, 594, 394, 511, 327, 589, 777, 699, 688, 43, 408, 842, 383, 721, 521, 560, 644, 714, 559, 62, 145, 873, 663, 713, 159, 672, 729, 624, 59, 193, 417, 158, 209, 563, 564, 343, 693, 109, 608, 563, 365, 181, 772, 677, 310, 248, 353, 708, 410, 579, 870, 617, 841, 632, 860, 289, 536, 35, 777, 618, 586, 424, 833, 77, 597, 346, 269, 757, 632, 695, 751, 331, 247, 184, 45, 787, 680, 18, 66, 407, 369, 54, 492, 228, 613, 830, 922, 437, 519, 644, 905, 789, 420, 305, 441, 207, 300, 892, 827, 141, 537, 381, 662, 513, 56, 252, 341, 242, 797, 838, 837, 720, 224, 307, 631, 61, 87, 560, 310, 756, 665, 397, 808, 851, 309, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, 425, 216, 548, 249, 321, 881, 699, 535, 673, 782, 210, 815, 905, 303, 843, 922, 281, 73, 469, 791, 660, 162, 498, 308, 155, 422, 907, 817, 187, 62, 16, 425, 535, 336, 286, 437, 375, 273, 610, 296, 183, 923, 116, 667, 751, 353, 62, 366, 691, 379, 687, 842, 37, 357, 720, 742, 330, 5, 39, 923, 311, 424, 242, 749, 321, 54, 669, 316, 342, 299, 534, 105, 667, 488, 640, 672, 576, 540, 316, 486, 721, 610, 46, 656, 447, 171, 616, 464, 190, 531, 297, 321, 762, 752, 533, 175, 134, 14, 381, 433, 717, 45, 111, 20, 596, 284, 736, 138, 646, 411, 877, 669, 141, 919, 45, 780, 407, 164, 332, 899, 165, 726, 600, 325, 498, 655, 
    357, 752, 768, 223, 849, 647, 63, 310, 863, 251, 366, 304, 282, 738, 675, 410, 389, 244, 31, 121, 303, 263};

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final String[] f327J = {"urA", "xfs", "ypy", "unk", "xdw", "yoz", "pDA", "uls", "pBk", "eBA", "pAs", "eAk", "prA", "uvs", "xhy", "pnk", "utw", "xgz", "fDA", "pls", "fBk", "frA", "pvs", "uxy", "fnk", "ptw", "uwz", "fls", "psy", "fvs", "pxy", "ftw", "pwz", "fxy", "yrx", "ufk", "xFw", "ymz", "onA", "uds", "xEy", "olk", "ucw", "dBA", "oks", "uci", "dAk", "okg", "dAc", "ovk", "uhw", "xaz", "dnA", "ots", "ugy", "dlk", "osw", "ugj", "dks", "osi", "dvk", "oxw", "uiz", "dts", "owy", "dsw", "owj", "dxw", "oyz", "dwy", "dwj", "ofA", "uFs", "xCy", "odk", "uEw", "xCj", "clA", "ocs", "uEi", "ckk", "ocg", "ckc", "ckE", "cvA", "ohs", "uay", "ctk", "ogw", "uaj", "css", "ogi", "csg", "csa", "cxs", "oiy", "cww", "oij", "cwi", "cyy", "oFk", "uCw", "xBj", "cdA", "oEs", "uCi", "cck", "oEg", "uCb", "ccc", "oEa", "ccE", "oED", "chk", "oaw", "uDj", "cgs", "oai", "cgg", "oab", "cga", "cgD", "obj", "cib", "cFA", "oCs", "uBi", "cEk", "oCg", "uBb", "cEc", "oCa", "cEE", "oCD", "cEC", "cas", "cag", "caa", "cCk", "uAr", "oBa", "oBD", "cCB", "tfk", "wpw", "yez", "mnA", "tds", "woy", "mlk", "tcw", "woj", "FBA", "mks", "FAk", "mvk", "thw", "wqz", "FnA", "mts", "tgy", "Flk", "msw", "Fks", "Fkg", "Fvk", "mxw", "tiz", "Fts", "mwy", "Fsw", "Fsi", "Fxw", "myz", "Fwy", "Fyz", "vfA", "xps", "yuy", "vdk", "xow", "yuj", "qlA", "vcs", "xoi", "qkk", "vcg", "xob", "qkc", "vca", "mfA", "tFs", "wmy", "qvA", "mdk", "tEw", "wmj", "qtk", "vgw", "xqj", "hlA", "Ekk", "mcg", "tEb", "hkk", "qsg", "hkc", "EvA", "mhs", "tay", "hvA", "Etk", "mgw", "taj", "htk", "qww", "vij", "hss", "Esg", "hsg", "Exs", "miy", "hxs", "Eww", "mij", "hww", "qyj", "hwi", "Eyy", "hyy", "Eyj", "hyj", "vFk", "xmw", "ytj", "qdA", "vEs", "xmi", "qck", "vEg", "xmb", "qcc", "vEa", "qcE", "qcC", "mFk", "tCw", "wlj", "qhk", "mEs", "tCi", "gtA", "Eck", "vai", "tCb", "gsk", "Ecc", "mEa", "gsc", "qga", "mED", "EcC", "Ehk", "maw", "tDj", "gxk", "Egs", "mai", "gws", "qii", "mab", "gwg", "Ega", "EgD", "Eiw", "mbj", "gyw", "Eii", "gyi", "Eib", "gyb", "gzj", "qFA", "vCs", "xli", "qEk", "vCg", "xlb", "qEc", "vCa", "qEE", "vCD", "qEC", "qEB", "EFA", "mCs", "tBi", "ghA", "EEk", "mCg", "tBb", "ggk", "qag", "vDb", "ggc", "EEE", "mCD", "ggE", "qaD", "ggC", "Eas", "mDi", "gis", "Eag", "mDb", "gig", "qbb", "gia", "EaD", "giD", "gji", "gjb", "qCk", "vBg", "xkr", "qCc", "vBa", "qCE", "vBD", "qCC", "qCB", "ECk", "mBg", "tAr", "gak", "ECc", "mBa", "gac", "qDa", "mBD", "gaE", "ECC", "gaC", "ECB", "EDg", "gbg", "gba", "gbD", "vAq", "vAn", "qBB", "mAq", "EBE", "gDE", "gDC", "gDB", "lfA", "sps", "wey", "ldk", "sow", "ClA", "lcs", "soi", "Ckk", "lcg", "Ckc", "CkE", "CvA", "lhs", "sqy", "Ctk", "lgw", "sqj", "Css", "lgi", "Csg", "Csa", "Cxs", "liy", "Cww", "lij", "Cwi", "Cyy", "Cyj", "tpk", "wuw", "yhj", "ndA", "tos", "wui", "nck", "tog", "wub", "ncc", "toa", "ncE", "toD", "lFk", "smw", "wdj", "nhk", "lEs", "smi", "atA", "Cck", "tqi", "smb", "ask", "ngg", "lEa", "asc", "CcE", "asE", "Chk", "law", "snj", "axk", "Cgs", "trj", "aws", "nii", "lab", "awg", "Cga", "awa", "Ciw", "lbj", "ayw", "Cii", "ayi", "Cib", "Cjj", "azj", "vpA", "xus", "yxi", "vok", "xug", "yxb", "voc", "xua", "voE", "xuD", "voC", "nFA", "tms", "wti", "rhA", "nEk", "xvi", "wtb", "rgk", "vqg", "xvb", "rgc", "nEE", "tmD", "rgE", "vqD", "nEB", "CFA", "lCs", "sli", "ahA", "CEk", "lCg", "slb", "ixA", "agk", "nag", "tnb", "iwk", "rig", "vrb", "lCD", "iwc", "agE", "naD", "iwE", "CEB", "Cas", "lDi", "ais", "Cag", "lDb", "iys", "aig", "nbb", "iyg", "rjb", "CaD", "aiD", "Cbi", "aji", "Cbb", "izi", "ajb", "vmk", "xtg", "ywr", "vmc", "xta", "vmE", "xtD", "vmC", "vmB", "nCk", "tlg", "wsr", "rak", "nCc", "xtr", "rac", "vna", "tlD", "raE", "nCC", "raC", "nCB", "raB", "CCk", "lBg", "skr", "aak", "CCc", "lBa", "iik", "aac", "nDa", "lBD", "iic", "rba", "CCC", "iiE", "aaC", "CCB", "aaB", "CDg", "lBr", "abg", "CDa", "ijg", "aba", "CDD", "ija", "abD", "CDr", "ijr", "vlc", "xsq", "vlE", "xsn", "vlC", "vlB", "nBc", "tkq", "rDc", "nBE", "tkn", "rDE", "vln", "rDC", "nBB", "rDB", "CBc", "lAq", "aDc", "CBE", "lAn", "ibc", "aDE", "nBn", "ibE", "rDn", "CBB", "ibC", "aDB", "ibB", "aDq", "ibq", "ibn", "xsf", "vkl", "tkf", "nAm", "nAl", "CAo", "aBo", "iDo", "CAl", "aBl", "kpk", "BdA", "kos", "Bck", "kog", "seb", "Bcc", "koa", "BcE", "koD", "Bhk", "kqw", "sfj", "Bgs", "kqi", "Bgg", "kqb", "Bga", "BgD", "Biw", "krj", "Bii", "Bib", "Bjj", "lpA", "sus", "whi", "lok", "sug", "loc", "sua", "loE", "suD", "loC", "BFA", "kms", "sdi", "DhA", "BEk", "svi", "sdb", "Dgk", "lqg", "svb", "Dgc", "BEE", "kmD", "DgE", "lqD", "BEB", "Bas", "kni", "Dis", "Bag", "knb", "Dig", "lrb", "Dia", "BaD", "Bbi", "Dji", "Bbb", "Djb", "tuk", "wxg", "yir", "tuc", "wxa", "tuE", "wxD", "tuC", "tuB", "lmk", "stg", "nqk", "lmc", "sta", "nqc", "tva", "stD", "nqE", "lmC", "nqC", "lmB", "nqB", "BCk", "klg", "Dak", "BCc", "str", "bik", "Dac", "lna", "klD", "bic", "nra", "BCC", "biE", "DaC", "BCB", "DaB", "BDg", "klr", "Dbg", "BDa", "bjg", "Dba", "BDD", "bja", "DbD", "BDr", "Dbr", "bjr", "xxc", "yyq", "xxE", "yyn", "xxC", "xxB", "ttc", "wwq", "vvc", "xxq", "wwn", "vvE", "xxn", "vvC", "ttB", "vvB", "llc", "ssq", "nnc", "llE", "ssn", "rrc", "nnE", "ttn", "rrE", "vvn", "llB", "rrC", "nnB", "rrB", "BBc", "kkq", "DDc", "BBE", "kkn", "bbc", "DDE", "lln", "jjc", "bbE", "nnn", "BBB", "jjE", "rrn", "DDB", "jjC", "BBq", "DDq", "BBn", "bbq", "DDn", "jjq", "bbn", "jjn", "xwo", "yyf", "xwm", "xwl", "tso", "wwf", "vto", "xwv", "vtm", "tsl", "vtl", "lko", "ssf", "nlo", "lkm", "rno", "nlm", "lkl", "rnm", "nll", "rnl", "BAo", "kkf", "DBo", "lkv", "bDo", "DBm", "BAl", "jbo", "bDm", "DBl", "jbm", "bDl", "jbl", "DBv", "jbv", "xwd", "vsu", "vst", "nku", "rlu", "rlt", "DAu", "bBu", "jDu", "jDt", "ApA", "Aok", "keg", "Aoc", "AoE", "AoC", "Aqs", "Aqg", "Aqa", "AqD", "Ari", "Arb", "kuk", "kuc", "sha", "kuE", "shD", "kuC", "kuB", "Amk", "kdg", "Bqk", "kvg", "kda", "Bqc", "kva", "BqE", "kvD", "BqC", "AmB", "BqB", "Ang", "kdr", "Brg", "kvr", "Bra", "AnD", "BrD", "Anr", "Brr", "sxc", "sxE", "sxC", "sxB", "ktc", "lvc", "sxq", "sgn", "lvE", "sxn", "lvC", "ktB", "lvB", "Alc", "Bnc", "AlE", "kcn", "Drc", "BnE", "AlC", "DrE", "BnC", "AlB", "DrC", "BnB", "Alq", "Bnq", "Aln", "Drq", "Bnn", "Drn", "wyo", "wym", "wyl", "swo", "txo", "wyv", "txm", "swl", "txl", "kso", "sgf", "lto", "swv", "nvo", "ltm", "ksl", "nvm", "ltl", "nvl", "Ako", "kcf", "Blo", "ksv", "Dno", "Blm", "Akl", "bro", "Dnm", "Bll", "brm", "Dnl", "Akv", "Blv", "Dnv", "brv", "yze", "yzd", "wye", "xyu", "wyd", "xyt", "swe", "twu", "swd", "vxu", "twt", "vxt", "kse", "lsu", "ksd", "ntu", "lst", "rvu", "ypk", "zew", "xdA", "yos", "zei", "xck", "yog", "zeb", "xcc", "yoa", "xcE", "yoD", "xcC", "xhk", "yqw", "zfj", "utA", "xgs", "yqi", "usk", "xgg", "yqb", "usc", "xga", "usE", "xgD", "usC", "uxk", "xiw", "yrj", "ptA", "uws", "xii", "psk", "uwg", "xib", "psc", "uwa", "psE", "uwD", "psC", "pxk", "uyw", "xjj", "ftA", "pws", "uyi", "fsk", "pwg", "uyb", "fsc", "pwa", "fsE", "pwD", "fxk", "pyw", "uzj", "fws", "pyi", "fwg", "pyb", "fwa", "fyw", "pzj", "fyi", "fyb", "xFA", "yms", "zdi", "xEk", "ymg", 
    "zdb", "xEc", "yma", "xEE", "ymD", "xEC", "xEB", "uhA", "xas", "yni", "ugk", "xag", "ynb", "ugc", "xaa", "ugE", "xaD", "ugC", "ugB", "oxA", "uis", "xbi", "owk", "uig", "xbb", "owc", "uia", "owE", "uiD", "owC", "owB", "dxA", "oys", "uji", "dwk", "oyg", "ujb", "dwc", "oya", "dwE", "oyD", "dwC", "dys", "ozi", "dyg", "ozb", "dya", "dyD", "dzi", "dzb", "xCk", "ylg", "zcr", "xCc", "yla", "xCE", "ylD", "xCC", "xCB", "uak", "xDg", "ylr", "uac", "xDa", "uaE", "xDD", "uaC", "uaB", "oik", "ubg", "xDr", "oic", "uba", "oiE", "ubD", "oiC", "oiB", "cyk", "ojg", "ubr", "cyc", "oja", "cyE", "ojD", "cyC", "cyB", "czg", "ojr", "cza", "czD", "czr", "xBc", "ykq", "xBE", "ykn", "xBC", "xBB", "uDc", "xBq", "uDE", "xBn", "uDC", "uDB", "obc", "uDq", "obE", "uDn", "obC", "obB", "cjc", "obq", "cjE", "obn", "cjC", "cjB", "cjq", "cjn", "xAo", "ykf", "xAm", "xAl", "uBo", "xAv", "uBm", "uBl", "oDo", "uBv", "oDm", "oDl", "cbo", "oDv", "cbm", "cbl", "xAe", "xAd", "uAu", "uAt", "oBu", "oBt", "wpA", "yes", "zFi", "wok", "yeg", "zFb", "woc", "yea", "woE", "yeD", "woC", "woB", "thA", "wqs", "yfi", "tgk", "wqg", "yfb", "tgc", "wqa", "tgE", "wqD", "tgC", "tgB", "mxA", "tis", "wri", "mwk", "tig", "wrb", "mwc", "tia", "mwE", "tiD", "mwC", "mwB", "FxA", "mys", "tji", "Fwk", "myg", "tjb", "Fwc", "mya", "FwE", "myD", "FwC", "Fys", "mzi", "Fyg", "mzb", "Fya", "FyD", "Fzi", "Fzb", "yuk", "zhg", "hjs", "yuc", "zha", "hbw", "yuE", "zhD", "hDy", "yuC", "yuB", "wmk", "ydg", "zEr", "xqk", "wmc", "zhr", "xqc", "yva", "ydD", "xqE", "wmC", "xqC", "wmB", "xqB", "tak", "wng", "ydr", "vik", "tac", "wna", "vic", "xra", "wnD", "viE", "taC", "viC", "taB", "viB", "mik", "tbg", "wnr", "qyk", "mic", "tba", "qyc", "vja", "tbD", "qyE", "miC", "qyC", "miB", "qyB", "Eyk", "mjg", "tbr", "hyk", "Eyc", "mja", "hyc", "qza", "mjD", "hyE", "EyC", "hyC", "EyB", "Ezg", "mjr", "hzg", "Eza", "hza", "EzD", "hzD", "Ezr", "ytc", "zgq", "grw", "ytE", "zgn", "gny", "ytC", "glz", "ytB", "wlc", "ycq", "xnc", "wlE", "ycn", "xnE", "ytn", "xnC", "wlB", "xnB", "tDc", "wlq", "vbc", "tDE", "wln", "vbE", "xnn", "vbC", "tDB", "vbB", "mbc", "tDq", "qjc", "mbE", "tDn", "qjE", "vbn", "qjC", "mbB", "qjB", "Ejc", "mbq", "gzc", "EjE", "mbn", "gzE", "qjn", "gzC", "EjB", "gzB", "Ejq", "gzq", "Ejn", "gzn", "yso", "zgf", "gfy", "ysm", "gdz", "ysl", "wko", "ycf", "xlo", "ysv", "xlm", "wkl", "xll", "tBo", "wkv", "vDo", "tBm", "vDm", "tBl", "vDl", "mDo", "tBv", "qbo", "vDv", "qbm", "mDl", "qbl", "Ebo", "mDv", "gjo", "Ebm", "gjm", "Ebl", "gjl", "Ebv", "gjv", "yse", "gFz", "ysd", "wke", "xku", "wkd", "xkt", "tAu", "vBu", "tAt", "vBt", "mBu", "qDu", "mBt", "qDt", "EDu", "gbu", "EDt", "gbt", "ysF", "wkF", "xkh", "tAh", "vAx", "mAx", "qBx", "wek", "yFg", "zCr", "wec", "yFa", "weE", "yFD", "weC", "weB", "sqk", "wfg", "yFr", "sqc", "wfa", "sqE", "wfD", "sqC", "sqB", "lik", "srg", "wfr", "lic", "sra", "liE", "srD", "liC", "liB", "Cyk", "ljg", "srr", "Cyc", "lja", "CyE", "ljD", "CyC", "CyB", "Czg", "ljr", "Cza", "CzD", "Czr", "yhc", "zaq", "arw", "yhE", "zan", "any", "yhC", "alz", "yhB", "wdc", "yEq", "wvc", "wdE", "yEn", "wvE", "yhn", "wvC", "wdB", "wvB", "snc", "wdq", "trc", "snE", "wdn", "trE", "wvn", "trC", "snB", "trB", "lbc", "snq", "njc", "lbE", "snn", "njE", "trn", "njC", "lbB", "njB", "Cjc", "lbq", "azc", "CjE", "lbn", "azE", "njn", "azC", "CjB", "azB", "Cjq", "azq", "Cjn", "azn", "zio", "irs", "rfy", "zim", "inw", "rdz", "zil", "ily", "ikz", "ygo", "zaf", "afy", "yxo", "ziv", "ivy", "adz", "yxm", "ygl", "itz", "yxl", "wco", "yEf", "wto", "wcm", "xvo", "yxv", "wcl", "xvm", "wtl", "xvl", "slo", "wcv", "tno", "slm", "vro", "tnm", "sll", "vrm", "tnl", "vrl", "lDo", "slv", "nbo", "lDm", "rjo", "nbm", "lDl", "rjm", "nbl", "rjl", "Cbo", "lDv", "ajo", "Cbm", "izo", "ajm", "Cbl", "izm", "ajl", "izl", "Cbv", "ajv", "zie", "ifw", "rFz", "zid", "idy", "icz", "yge", "aFz", "ywu", "ygd", "ihz", "ywt", "wce", "wsu", "wcd", "xtu", "wst", "xtt", "sku", "tlu", "skt", "vnu", "tlt", "vnt", "lBu", "nDu", "lBt", "rbu", "nDt", "rbt", "CDu", "abu", "CDt", "iju", "abt", "ijt", "ziF", "iFy", "iEz", "ygF", "ywh", "wcF", "wsh", "xsx", "skh", "tkx", "vlx", "lAx", "nBx", "rDx", "CBx", "aDx", "ibx", "iCz", "wFc", "yCq", "wFE", "yCn", "wFC", "wFB", "sfc", "wFq", "sfE", "wFn", "sfC", "sfB", "krc", "sfq", "krE", "sfn", "krC", "krB", "Bjc", "krq", "BjE", "krn", "BjC", "BjB", "Bjq", "Bjn", "yao", "zDf", "Dfy", "yam", "Ddz", "yal", "wEo", "yCf", "who", "wEm", "whm", "wEl", "whl", "sdo", "wEv", "svo", "sdm", "svm", "sdl", "svl", "kno", "sdv", "lro", "knm", "lrm", "knl", "lrl", "Bbo", "knv", "Djo", "Bbm", "Djm", "Bbl", "Djl", "Bbv", "Djv", "zbe", "bfw", "npz", "zbd", "bdy", "bcz", "yae", "DFz", "yiu", "yad", "bhz", "yit", "wEe", "wgu", "wEd", "wxu", "wgt", "wxt", "scu", "stu", "sct", "tvu", "stt", "tvt", "klu", "lnu", "klt", "nru", "lnt", "nrt", "BDu", "Dbu", "BDt", "bju", "Dbt", "bjt", "jfs", "rpy", "jdw", "roz", "jcy", "jcj", "zbF", "bFy", "zjh", "jhy", "bEz", "jgz", "yaF", "yih", "yyx", "wEF", "wgh", "wwx", "xxx", "sch", "ssx", "ttx", "vvx", "kkx", "llx", "nnx", "rrx", "BBx", "DDx", "bbx", "jFw", "rmz", "jEy", "jEj", "bCz", "jaz", "jCy", "jCj", "jBj", "wCo", "wCm", "wCl", "sFo", "wCv", "sFm", "sFl", "kfo", "sFv", "kfm", "kfl", "Aro", "kfv", "Arm", "Arl", "Arv", "yDe", "Bpz", "yDd", "wCe", "wau", "wCd", "wat", "sEu", "shu", "sEt", "sht", "kdu", "kvu", "kdt", "kvt", "Anu", "Bru", "Ant", "Brt", "zDp", "Dpy", "Doz", "yDF", "ybh", "wCF", "wah", "wix", "sEh", "sgx", "sxx", "kcx", "ktx", "lvx", "Alx", "Bnx", "Drx", "bpw", "nuz", "boy", "boj", "Dmz", "bqz", "jps", "ruy", "jow", "ruj", "joi", "job", "bmy", "jqy", "bmj", "jqj", "jmw", "rtj", "jmi", "jmb", "blj", "jnj", "jli", "jlb", "jkr", "sCu", "sCt", "kFu", "kFt", "Afu", "Aft", "wDh", "sCh", "sax", "kEx", "khx", "Adx", "Avx", "Buz", "Duy", "Duj", "buw", "nxj", "bui", "bub", "Dtj", "bvj", "jus", "rxi", "jug", "rxb", "jua", "juD", "bti", "jvi", "btb", "jvb", "jtg", "rwr", "jta", "jtD", "bsr", "jtr", "jsq", "jsn", "Bxj", "Dxi", "Dxb", "bxg", "nyr", "bxa", "bxD", "Dwr", "bxr", "bwq", "bwn", "pjk", "urw", "ejA", "pbs", "uny", "ebk", "pDw", "ulz", "eDs", "pBy", "eBw", "zfc", "fjk", "prw", "zfE", "fbs", "pny", "zfC", "fDw", "plz", "zfB", "fBy", "yrc", "zfq", "frw", "yrE", "zfn", "fny", "yrC", "flz", "yrB", "xjc", "yrq", "xjE", "yrn", "xjC", "xjB", "uzc", "xjq", "uzE", "xjn", "uzC", "uzB", "pzc", "uzq", "pzE", "uzn", "pzC", "djA", "ors", "ufy", "dbk", "onw", "udz", "dDs", "oly", "dBw", "okz", "dAy", "zdo", "drs", "ovy", "zdm", "dnw", "otz", "zdl", "dly", "dkz", "yno", "zdv", "dvy", "ynm", "dtz", "ynl", "xbo", "ynv", "xbm", "xbl", "ujo", "xbv", "ujm", "ujl", "ozo", "ujv", "ozm", "ozl", "crk", "ofw", "uFz", "cns", "ody", "clw", "ocz", "cky", "ckj", "zcu", "cvw", "ohz", "zct", "cty", "csz", "ylu", "cxz", "ylt", "xDu", "xDt", "ubu", "ubt", "oju", "ojt", "cfs", "oFy", "cdw", "oEz", "ccy", "ccj", "zch", "chy", "cgz", "ykx", "xBx", "uDx", "cFw", "oCz", "cEy", "cEj", "caz", "cCy", "cCj", "FjA", "mrs", "tfy", "Fbk", "mnw", "tdz", "FDs", "mly", "FBw", "mkz", "FAy", "zFo", "Frs", 
    "mvy", "zFm", "Fnw", "mtz", "zFl", "Fly", "Fkz", "yfo", "zFv", "Fvy", "yfm", "Ftz", "yfl", "wro", "yfv", "wrm", "wrl", "tjo", "wrv", "tjm", "tjl", "mzo", "tjv", "mzm", "mzl", "qrk", "vfw", "xpz", "hbA", "qns", "vdy", "hDk", "qlw", "vcz", "hBs", "qky", "hAw", "qkj", "hAi", "Erk", "mfw", "tFz", "hrk", "Ens", "mdy", "hns", "qty", "mcz", "hlw", "Eky", "hky", "Ekj", "hkj", "zEu", "Evw", "mhz", "zhu", "zEt", "hvw", "Ety", "zht", "hty", "Esz", "hsz", "ydu", "Exz", "yvu", "ydt", "hxz", "yvt", "wnu", "xru", "wnt", "xrt", "tbu", "vju", "tbt", "vjt", "mju", "mjt", "grA", "qfs", "vFy", "gnk", "qdw", "vEz", "gls", "qcy", "gkw", "qcj", "gki", "gkb", "Efs", "mFy", "gvs", "Edw", "mEz", "gtw", "qgz", "gsy", "Ecj", "gsj", "zEh", "Ehy", "zgx", "gxy", "Egz", "gwz", "ycx", "ytx", "wlx", "xnx", "tDx", "vbx", "mbx", "gfk", "qFw", "vCz", "gds", "qEy", "gcw", "qEj", "gci", "gcb", "EFw", "mCz", "ghw", "EEy", "ggy", "EEj", "ggj", "Eaz", "giz", "gFs", "qCy", "gEw", "qCj", "gEi", "gEb", "ECy", "gay", "ECj", "gaj", "gCw", "qBj", "gCi", "gCb", "EBj", "gDj", "gBi", "gBb", "Crk", "lfw", "spz", "Cns", "ldy", "Clw", "lcz", "Cky", "Ckj", "zCu", "Cvw", "lhz", "zCt", "Cty", "Csz", "yFu", "Cxz", "yFt", "wfu", "wft", "sru", "srt", "lju", "ljt", "arA", "nfs", "tpy", "ank", "ndw", "toz", "als", "ncy", "akw", "ncj", "aki", "akb", "Cfs", "lFy", "avs", "Cdw", "lEz", "atw", "ngz", "asy", "Ccj", "asj", "zCh", "Chy", "zax", "axy", "Cgz", "awz", "yEx", "yhx", "wdx", "wvx", "snx", "trx", "lbx", "rfk", "vpw", "xuz", "inA", "rds", "voy", "ilk", "rcw", "voj", "iks", "rci", "ikg", "rcb", "ika", "afk", "nFw", "tmz", "ivk", "ads", "nEy", "its", "rgy", "nEj", "isw", "aci", "isi", "acb", "isb", "CFw", "lCz", "ahw", "CEy", "ixw", "agy", "CEj", "iwy", "agj", "iwj", "Caz", "aiz", "iyz", "ifA", "rFs", "vmy", "idk", "rEw", "vmj", "ics", "rEi", "icg", "rEb", "ica", "icD", "aFs", "nCy", "ihs", "aEw", "nCj", "igw", "raj", "igi", "aEb", "igb", "CCy", "aay", "CCj", "iiy", "aaj", "iij", "iFk", "rCw", "vlj", "iEs", "rCi", "iEg", "rCb", "iEa", "iED", "aCw", "nBj", "iaw", "aCi", "iai", "aCb", "iab", "CBj", "aDj", "ibj", "iCs", "rBi", "iCg", "rBb", "iCa", "iCD", "aBi", "iDi", "aBb", "iDb", "iBg", "rAr", "iBa", "iBD", "aAr", "iBr", "iAq", "iAn", "Bfs", "kpy", "Bdw", "koz", "Bcy", "Bcj", "Bhy", "Bgz", "yCx", "wFx", "sfx", "krx", "Dfk", "lpw", "suz", "Dds", "loy", "Dcw", "loj", "Dci", "Dcb", "BFw", "kmz", "Dhw", "BEy", "Dgy", "BEj", "Dgj", "Baz", "Diz", "bfA", "nps", "tuy", "bdk", "now", "tuj", "bcs", "noi", "bcg", "nob", "bca", "bcD", "DFs", "lmy", "bhs", "DEw", "lmj", "bgw", "DEi", "bgi", "DEb", "bgb", "BCy", "Day", "BCj", "biy", "Daj", "bij", "rpk", "vuw", "xxj", "jdA", "ros", "vui", "jck", "rog", "vub", "jcc", "roa", "jcE", "roD", "jcC", "bFk", "nmw", "ttj", "jhk", "bEs", "nmi", "jgs", "rqi", "nmb", "jgg", "bEa", "jga", "bED", "jgD", "DCw", "llj", "baw", "DCi", "jiw", "bai", "DCb", "jii", "bab", "jib", "BBj", "DDj", "bbj", "jjj", "jFA", "rms", "vti", "jEk", "rmg", "vtb", "jEc", "rma", "jEE", "rmD", "jEC", "jEB", "bCs", "nli", "jas", "bCg", "nlb", "jag", "rnb", "jaa", "bCD", "jaD", "DBi", "bDi", "DBb", "jbi", "bDb", "jbb", "jCk", "rlg", "vsr", "jCc", "rla", "jCE", "rlD", "jCC", "jCB", "bBg", "nkr", "jDg", "bBa", "jDa", "bBD", "jDD", "DAr", "bBr", "jDr", "jBc", "rkq", "jBE", "rkn", "jBC", "jBB", "bAq", "jBq", "bAn", "jBn", "jAo", "rkf", "jAm", "jAl", "bAf", "jAv", "Apw", "kez", "Aoy", "Aoj", "Aqz", "Bps", "kuy", "Bow", "kuj", "Boi", "Bob", "Amy", "Bqy", "Amj", "Bqj", "Dpk", "luw", "sxj", "Dos", "lui", "Dog", "lub", "Doa", "DoD", "Bmw", "ktj", "Dqw", "Bmi", "Dqi", "Bmb", "Dqb", "Alj", "Bnj", "Drj", "bpA", "nus", "txi", "bok", "nug", "txb", "boc", "nua", "boE", "nuD", "boC", "boB", "Dms", "lti", "bqs", "Dmg", "ltb", "bqg", "nvb", "bqa", "DmD", "bqD", "Bli", "Dni", "Blb", "bri", "Dnb", "brb", "ruk", "vxg", "xyr", "ruc", "vxa", "ruE", "vxD", "ruC", "ruB", "bmk", "ntg", "twr", "jqk", "bmc", "nta", "jqc", "rva", "ntD", "jqE", "bmC", "jqC", "bmB", "jqB", "Dlg", "lsr", "bng", "Dla", "jrg", "bna", "DlD", "jra", "bnD", "jrD", "Bkr", "Dlr", "bnr", "jrr", "rtc", "vwq", "rtE", "vwn", "rtC", "rtB", "blc", "nsq", "jnc", "blE", "nsn", "jnE", "rtn", "jnC", "blB", "jnB", "Dkq", "blq", "Dkn", "jnq", "bln", "jnn", "rso", "vwf", "rsm", "rsl", "bko", "nsf", "jlo", "bkm", "jlm", "bkl", "jll", "Dkf", "bkv", "jlv", "rse", "rsd", "bke", "jku", "bkd", "jkt", "Aey", "Aej", "Auw", "khj", "Aui", "Aub", "Adj", "Avj", "Bus", "kxi", "Bug", "kxb", "Bua", "BuD", "Ati", "Bvi", "Atb", "Bvb", "Duk", "lxg", "syr", "Duc", "lxa", "DuE", "lxD", "DuC", "DuB", "Btg", "kwr", "Dvg", "lxr", "Dva", "BtD", "DvD", "Asr", "Btr", "Dvr", "nxc", "tyq", "nxE", "tyn", "nxC", "nxB", "Dtc", "lwq", "bvc", "nxq", "lwn", "bvE", "DtC", "bvC", "DtB", "bvB", "Bsq", "Dtq", "Bsn", "bvq", "Dtn", "bvn", "vyo", "xzf", "vym", "vyl", "nwo", "tyf", "rxo", "nwm", "rxm", "nwl", "rxl", "Dso", "lwf", "bto", "Dsm", "jvo", "btm", "Dsl", "jvm", "btl", "jvl", "Bsf", "Dsv", "btv", "jvv", "vye", "vyd", "nwe", "rwu", "nwd", "rwt", "Dse", "bsu", "Dsd", "jtu", "bst", "jtt", "vyF", "nwF", "rwh", "DsF", "bsh", "jsx", "Ahi", "Ahb", "Axg", "kir", "Axa", "AxD", "Agr", "Axr", "Bxc", "kyq", "BxE", "kyn", "BxC", "BxB", "Awq", "Bxq", "Awn", "Bxn", "lyo", "szf", "lym", "lyl", "Bwo", "kyf", "Dxo", "lyv", "Dxm", "Bwl", "Dxl", "Awf", "Bwv", "Dxv", "tze", "tzd", "lye", "nyu", "lyd", "nyt", "Bwe", "Dwu", "Bwd", "bxu", "Dwt", "bxt", "tzF", "lyF", "nyh", "BwF", "Dwh", "bwx", "Aiq", "Ain", "Ayo", "kjf", "Aym", "Ayl", "Aif", "Ayv", "kze", "kzd", "Aye", "Byu", "Ayd", "Byt", "szp"};

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    private static final char[] f328K = {'A', 'B', 'C', 'D', 'E', 'F', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '*', '+', '-'};

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    private static final String[] f329L = {"00000", "00001", "00010", "00011", "00100", "00101", "00110", "00111", "01000", "01001", "01010", "01011", "01100", "01101", "01110", "01111", "10000", "10001", "10010", "10011", "10100", "10101", "10110", "10111", "11000", "11001", "11010", "11011", "11100", "11101", "11110", "11111", "01", "1111111101010100", "11111101000101001"};

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    private static final int[] f330M = {7, 8, 8, 4, 12, 4, 4, 8, 8, 8, 12, 4, 12, 12, 12, 12, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 12, 8, 8, 4, 8, 8, 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 8, 8, 8, 4, 8, 8, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 8, 8, 8, 8};

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    private static final int[] f331N = {26, 10, 20, 15, 18, 21, 10, 28, 23, 24, 22, 20, 13, 16, 17, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 14, 0, 1, 23, 2, 25, 3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 4, 5, 6, 24, 7, 8, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 21, 27, 9};

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    private static final int[] f332O = {4, 6, 7, 8, 8, 10, 10, 12, 12, 13, 14, 16, 18, 18, 19, 20, 24, 24, 24, 29, 30, 33, 34, 37, 39, 46, 54, 58, 70, 72, 82, 90, 108, 126, 1, 14, 2, 7, 24, 3, 15, 25, 4, 8, 16, 5, 17, 26, 9, 6, 10, 18, 27, 11, 28, 12, 19, 13, 29, 20, 30, 21, 22, 31, 23, 32, 33, 34};

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    private static final int[] f333P = {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 11, 14, 17, 20, 24, 28, 8, 11, 14, 17, 20, 23, 26, 6, 8, 10, 12, 15, 20, 26, 32, 38, 44, 4, 6, 8, 10, 12, 15, 20, 26, 32, 38, 44, 7, 7, 7, 8, 8, 8, 8, 9, 9, 10, 11, 13, 15, 12, 14, 16, 18, 21, 26, 32, 38, 44, 50, 8, 12, 14, 16, 18, 21, 26, 32, 38, 44, 50, 0, 0, 0, 7, 7, 7, 7, 15, 15, 24, 34, 57, 84, 45, 70, 99, 115, 133, 154, 180, 212, 250, 294, 7, 45, 70, 99, 115, 133, 154, 180, 212, 250, 294};

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    private static final int[] f334Q = {1, 8, 36, 19, 9, 25, 1, 1, 8, 36, 19, 9, 27, 1, 7, 15, 25, 37, 1, 1, 21, 15, 1, 47, 1, 7, 15, 25, 37, 1, 1, 21, 15, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 7, 15, 25, 37, 17, 9, 29, 31, 25, 19, 1, 7, 15, 25, 37, 17, 9, 29, 31, 25, 9, 8, 36, 19, 17, 33, 1, 9, 8, 36, 19, 17, 35, 1, 7, 15, 25, 37, 33, 17, 37, 47, 49, 43, 1, 7, 15, 25, 37, 33, 17, 37, 47, 49, 0, 3, 6, 0, 6, 0, 0, 0, 3, 6, 0, 6, 6, 0, 0, 6, 0, 0, 0, 0, 6, 6, 0, 3, 0, 0, 6, 0, 0, 0, 0, 6, 6, 0};

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    private static final String[] f335R = {"", "221311", "311311", "312211", "222211", "213211", "214111", "223111", "313111", "322111", "412111", "421111", "331111", "241111", "232111", "231211", "321211", "411211", "411121", "411112", "321112", "312112", "311212", "311221", "311131", "311122", "311113", "221113", "221122", "221131", "221221", "222121", "312121", "321121", "231121", "231112", "222112", "213112", "212212", "212221", "212131", "212122", "212113", "211213", "211123", "211132", "211141", "211231", "211222", "211312", "211321", "211411", "212311"};

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    private static final String[] f336S = {"", "112231", "121231", "122131", "131131", "131221", "132121", "141121", "141211", "142111", "133111", "132211", "131311", "122311", "123211", "124111", "115111", "114211", "114121", "123121", "123112", "122212", "122221", "121321", "121411", "112411", "113311", "113221", "113212", "113122", "122122", "131122", "131113", "122113", "113113", "112213", "112222", "112312", "112321", "111421", "111331", "111322", "111232", "111223", "111133", "111124", "111214", "112114", "121114", "121123", "121132", "112132", "112141"};

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    private static final int[] f337T = {76, 925, 537, 597, 784, 691, 437, 237, 308, 436, 284, 646, 653, 428, 379, 567, 527, 622, 257, 289, 362, 501, 441, 205, 377, 457, 64, 244, 826, 841, 818, 691, 266, 612, 462, 45, 565, 708, 825, 213, 15, 68, 327, 602, 904, 597, 864, 757, 201, 646, 684, 347, 127, 388, 7, 69, 851, 764, 713, 342, 384, 606, 583, 322, 592, 678, 204, 184, 394, 692, 669, 677, 154, 187, 241, 286, 274, 354, 478, 915, 691, 833, 105, 215, 460, 829, 476, 109, 904, 664, 230, 5, 80, 74, 550, 575, 147, 868, 642, 274, 562, 232, 755, 599, 524, 801, 132, 295, 116, 442, 428, 295, 42, 176, 65, 279, 577, 315, 624, 37, 855, 275, 739, 120, 297, 312, 202, 560, 321, 233, 756, 760, 573, 108, 519, 781, 534, 129, 425, 681, 553, 422, 716, 763, 693, 624, 610, 310, 691, 347, 165, 193, 259, 568, 443, 284, 887, 544, 788, 93, 477, 760, 331, 608, 269, 121, 159, 830, 446, 893, 699, 245, 441, 454, 325, 858, 131, 847, 764, 169, 361, 575, 922, 525, 176, 586, 640, 321, 536, 742, 677, 742, 687, 284, 193, 517, 273, 494, 263, 147, 593, 800, 571, 320, 803, 133, 231, 390, 685, 330, 63, 410, 234, 228, 438, 848, 133, 703, 529, 721, 788, 322, 280, 159, 738, 586, 388, 684, 445, 680, 245, 595, 614, 233, 812, 32, 284, 658, 745, 229, 95, 689, 920, 771, 554, 289, 231, 125, 117, 518, 476, 36, 659, 848, 678, 64, 764, 840, 157, 915, 470, 876, 109, 25, 632, 405, 417, 436, 714, 60, 376, 97, 413, 706, 446, 21, 3, 773, 569, 267, 272, 213, 31, 560, 231, 758, 103, 271, 572, 436, 339, 730, 82, 285, 923, 797, 576, 875, 156, 706, 63, 81, 257, 874, 411, 416, 778, 50, 205, 303, 188, 535, 909, 155, 637, 230, 534, 96, 575, 102, 264, 233, 919, 593, 865, 26, 579, 623, 766, 146, 10, 739, 246, 127, 71, 244, 211, 477, 920, 876, 427, 820, 718, 435};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    private int f338A;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    private Integer f340C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    private Integer f341D;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final int[] f346z = new int[2700];

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    private c f339B = c.NORMAL;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    private int f342E = -1;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    private int f343F = 0;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    private int f344G = 1;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    private int f345H = 1;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f348b = 1;

        public a(b bVar) {
            this.f347a = bVar;
        }

        public String toString() {
            return this.f347a + "x" + this.f348b;
        }
    }

    private enum b {
        FALSE,
        TEX,
        BYT,
        NUM
    }

    public enum c {
        NORMAL,
        TRUNCATED,
        MICRO
    }

    public I() {
        B(3);
    }

    private void L() {
        if (this.f345H == 1) {
            return;
        }
        int[] iArr = this.f346z;
        int i3 = this.f338A;
        this.f338A = i3 + 1;
        iArr[i3] = 928;
        int i4 = this.f344G - 1;
        int[] iArr2 = new int[5];
        for (int i5 = 4; i5 >= 0; i5--) {
            iArr2[i5] = (i4 % 10) + 48;
            i4 /= 10;
        }
        S(iArr2, 0, 5, true);
        int[] iArr3 = this.f346z;
        int i6 = this.f338A;
        int i7 = i6 + 1;
        this.f338A = i7;
        iArr3[i6] = this.f343F;
        if (this.f344G == this.f345H) {
            this.f338A = i6 + 2;
            iArr3[i7] = 922;
        }
    }

    private static b M(int i3) {
        if (i3 < 48 || i3 > 57) {
            return (i3 == 9 || i3 == 10 || i3 == 13 || (i3 >= 32 && i3 <= 126)) ? b.TEX : b.BYT;
        }
        return b.NUM;
    }

    private static List N(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        a aVar = null;
        for (int i3 : iArr) {
            b bVarM = M(i3);
            if (aVar == null || aVar.f347a != bVarM || (bVarM == b.NUM && aVar.f348b >= 44)) {
                aVar = new a(bVarM);
                arrayList.add(aVar);
            } else {
                aVar.f348b++;
            }
        }
        W(arrayList);
        return arrayList;
    }

    private static int O(int i3, Integer num, Integer num2) {
        for (int i4 = 0; i4 < 34; i4++) {
            int[] iArr = f332O;
            if (i3 <= iArr[i4]) {
                int i5 = iArr[i4 + 34];
                int[] iArr2 = f333P;
                int i6 = iArr2[i5 - 1];
                int i7 = iArr2[i5 + 33];
                if ((num == null || num.intValue() == i6) && (num2 == null || num2.intValue() == i7)) {
                    return i5;
                }
            }
        }
        throw new H("Unable to determine MicroPDF417 variant for " + i3 + " codewords");
    }

    private static void P(List list) {
        int i3 = 1;
        while (i3 < list.size()) {
            a aVar = (a) list.get(i3 - 1);
            a aVar2 = (a) list.get(i3);
            b bVar = aVar.f347a;
            if (bVar == aVar2.f347a && (bVar != b.NUM || aVar.f348b + aVar2.f348b <= 44)) {
                aVar.f348b += aVar2.f348b;
                list.remove(i3);
                i3--;
            }
            i3++;
        }
    }

    private void Q(int i3, int i4, b bVar) {
        new BigInteger("0");
        new BigInteger("0");
        if (i4 == 1 && bVar == b.TEX) {
            int[] iArr = this.f346z;
            int i5 = this.f338A;
            int i6 = i5 + 1;
            this.f338A = i6;
            iArr[i5] = 913;
            this.f338A = i5 + 2;
            iArr[i6] = this.f415n[i3];
            return;
        }
        if (i4 % 6 == 0) {
            int[] iArr2 = this.f346z;
            int i7 = this.f338A;
            this.f338A = i7 + 1;
            iArr2[i7] = 924;
        } else {
            int[] iArr3 = this.f346z;
            int i8 = this.f338A;
            this.f338A = i8 + 1;
            iArr3[i8] = 901;
        }
        int i9 = 0;
        while (i9 < i4) {
            int i10 = i4 - i9;
            int i11 = 6;
            if (6 <= i10) {
                i9 += 6;
                BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
                while (true) {
                    int i12 = i11 - 1;
                    if (i11 == 0) {
                        break;
                    }
                    bigIntegerValueOf = bigIntegerValueOf.or(BigInteger.valueOf(this.f415n[i3]).shiftLeft(i12 * 8));
                    i11 = i12;
                    i3++;
                }
                int i13 = 5;
                while (true) {
                    int i14 = i13 - 1;
                    if (i13 == 0) {
                        break;
                    }
                    this.f346z[this.f338A + i14] = bigIntegerValueOf.mod(BigInteger.valueOf(900L)).intValue();
                    bigIntegerValueOf = bigIntegerValueOf.divide(BigInteger.valueOf(900L));
                    i13 = i14;
                }
                this.f338A += 5;
            } else {
                i9 += i10;
                while (true) {
                    int i15 = i10 - 1;
                    if (i10 != 0) {
                        int[] iArr4 = this.f346z;
                        int i16 = this.f338A;
                        this.f338A = i16 + 1;
                        iArr4[i16] = this.f415n[i3];
                        i10 = i15;
                        i3++;
                    }
                }
            }
        }
    }

    private void R() {
        int i3;
        int i4;
        int[] iArr = new int[5];
        int[] iArr2 = new int[50];
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        List listN = N(this.f415n);
        this.f338A = 0;
        if (this.f404c) {
            this.f346z[0] = 921;
            this.f338A = 1;
        }
        int i5 = this.f414m;
        if (i5 != 3) {
            if (i5 <= 899) {
                int[] iArr3 = this.f346z;
                int i6 = this.f338A;
                iArr3[i6] = 927;
                int i7 = i6 + 1;
                this.f338A = i7;
                iArr3[i7] = i5;
                this.f338A = i6 + 2;
            }
            if (i5 >= 900 && i5 <= 810899) {
                int[] iArr4 = this.f346z;
                int i8 = this.f338A;
                iArr4[i8] = 926;
                int i9 = i8 + 1;
                this.f338A = i9;
                iArr4[i9] = (i5 / 900) - 1;
                int i10 = i8 + 2;
                this.f338A = i10;
                iArr4[i10] = i5 % 900;
                this.f338A = i8 + 3;
            }
            if (i5 >= 810900 && i5 <= 811799) {
                int[] iArr5 = this.f346z;
                int i11 = this.f338A;
                iArr5[i11] = 925;
                int i12 = i11 + 1;
                this.f338A = i12;
                iArr5[i12] = i5 - 810900;
                this.f338A = i11 + 2;
            }
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < listN.size()) {
            a aVar = (a) listN.get(i13);
            int iOrdinal = aVar.f347a.ordinal();
            if (iOrdinal == 1) {
                U(i14, aVar.f348b, false);
            } else if (iOrdinal == 2) {
                Q(i14, aVar.f348b, i13 == 0 ? b.TEX : ((a) listN.get(i13 - 1)).f347a);
            } else {
                if (iOrdinal != 3) {
                    throw new H("Unknown block type: " + aVar.f347a);
                }
                S(this.f415n, i14, aVar.f348b, false);
            }
            i14 += aVar.f348b;
            i13++;
        }
        L();
        u("Codewords: ");
        for (int i15 = 0; i15 < this.f338A; i15++) {
            y(this.f346z[i15]);
        }
        v();
        Y(4, 44);
        X(1, 4);
        Integer num = this.f340C;
        if (num != null) {
            int iIntValue = num.intValue();
            if (iIntValue == 1) {
                i4 = 20;
            } else if (iIntValue == 2) {
                i4 = 37;
            } else if (iIntValue == 3) {
                i4 = 82;
            } else {
                if (iIntValue != 4) {
                    throw new H("Invalid column count: " + this.f340C);
                }
                i4 = 126;
            }
            if (this.f338A > i4) {
                throw new H("Too few columns (" + this.f340C + ") to hold data codewords (" + this.f338A + ")");
            }
        }
        int iO = O(this.f338A, this.f340C, this.f341D);
        int i16 = iO - 1;
        int[] iArr6 = f333P;
        this.f340C = Integer.valueOf(iArr6[i16]);
        int i17 = iO + 33;
        this.f341D = Integer.valueOf(iArr6[i17]);
        int i18 = iO + 67;
        int i19 = iArr6[i18];
        int iIntValue2 = (this.f340C.intValue() * this.f341D.intValue()) - i19;
        int i20 = iO + 101;
        int i21 = iArr6[i20];
        w("Data Codewords: " + iIntValue2);
        w("ECC Codewords: " + i19);
        for (int i22 = iIntValue2 - this.f338A; i22 > 0; i22--) {
            int[] iArr7 = this.f346z;
            int i23 = this.f338A;
            iArr7[i23] = 900;
            this.f338A = i23 + 1;
        }
        int i24 = this.f338A;
        for (int i25 = 0; i25 < 50; i25++) {
            iArr2[i25] = 0;
        }
        for (int i26 = 0; i26 < i24; i26++) {
            int i27 = i19 - 1;
            int i28 = (this.f346z[i26] + iArr2[i27]) % 929;
            while (i27 >= 0) {
                if (i27 == 0) {
                    iArr2[i27] = (929 - ((f337T[i21 + i27] * i28) % 929)) % 929;
                } else {
                    iArr2[i27] = ((iArr2[i27 - 1] + 929) - ((i28 * f337T[i21 + i27]) % 929)) % 929;
                }
                i27--;
                i24 = i24;
            }
        }
        for (int i29 = 0; i29 < i19; i29++) {
            int i30 = iArr2[i29];
            if (i30 != 0) {
                iArr2[i29] = 929 - i30;
            }
        }
        int i31 = 1;
        int i32 = i19 - 1;
        while (i32 >= 0) {
            int[] iArr8 = this.f346z;
            int i33 = this.f338A;
            iArr8[i33] = iArr2[i32];
            this.f338A = i33 + i31;
            i32--;
            i31 = 1;
        }
        int[] iArr9 = f334Q;
        int i34 = iArr9[i16];
        int i35 = iArr9[i17];
        int i36 = iArr9[i18];
        int i37 = iArr9[i20] / 3;
        this.f416o = "";
        this.f417p = new String[this.f341D.intValue()];
        this.f418q = this.f341D.intValue();
        this.f419r = new int[this.f341D.intValue()];
        w("Grid Size: " + this.f340C + " X " + this.f418q);
        int i38 = 0;
        while (i38 < this.f341D.intValue()) {
            int i39 = 0;
            sb.setLength(0);
            int i40 = i37 * 929;
            int i41 = 0;
            while (i41 < 5) {
                iArr[i41] = i39;
                i41++;
                i39 = 0;
            }
            int i42 = 0;
            while (i42 < this.f340C.intValue()) {
                int i43 = i42 + 1;
                iArr[i43] = this.f346z[(this.f340C.intValue() * i38) + i42];
                i42 = i43;
            }
            String[] strArr = f335R;
            sb.append(strArr[i34]);
            sb.append('1');
            String[] strArr2 = f327J;
            sb.append(strArr2[iArr[1] + i40]);
            sb.append('1');
            if (this.f340C.intValue() == 3) {
                sb.append(f336S[i35]);
            }
            if (this.f340C.intValue() >= 2) {
                sb.append('1');
                sb.append(strArr2[iArr[2] + i40]);
                sb.append('1');
            }
            if (this.f340C.intValue() == 4) {
                sb.append(f336S[i35]);
            }
            if (this.f340C.intValue() >= 3) {
                sb.append('1');
                sb.append(strArr2[iArr[3] + i40]);
                sb.append('1');
            }
            if (this.f340C.intValue() == 4) {
                sb.append('1');
                sb.append(strArr2[i40 + iArr[4]]);
                sb.append('1');
            }
            sb.append(strArr[i36]);
            sb.append('1');
            sb2.setLength(0);
            boolean z3 = true;
            for (int i44 = 0; i44 < sb.length(); i44++) {
                if (sb.charAt(i44) < '0' || sb.charAt(i44) > '9') {
                    sb2.append(f329L[G2.a.c(sb.charAt(i44), f328K)]);
                } else {
                    for (int i45 = 0; i45 < Character.getNumericValue(sb.charAt(i44)); i45++) {
                        if (z3) {
                            sb2.append('1');
                        } else {
                            sb2.append('0');
                        }
                    }
                    z3 = !z3;
                }
            }
            this.f417p[i38] = Q.a(sb2);
            this.f419r[i38] = this.f405d;
            int i46 = i34 + 1;
            int i47 = i35 + 1;
            i36++;
            i37++;
            if (i46 == 53) {
                i46 = 1;
            }
            if (i47 == 53) {
                i47 = 1;
            }
            if (i36 == 53) {
                i3 = 3;
                i36 = 1;
            } else {
                i3 = 3;
            }
            if (i37 == i3) {
                i37 = 0;
            }
            i38++;
            i35 = i47;
            i34 = i46;
        }
    }

    private void S(int[] iArr, int i3, int i4, boolean z3) {
        int[] iArr2 = new int[16];
        if (!z3) {
            int[] iArr3 = this.f346z;
            int i5 = this.f338A;
            this.f338A = i5 + 1;
            iArr3[i5] = 902;
        }
        StringBuilder sb = new StringBuilder(i4 + 1);
        sb.append('1');
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            sb.append((char) iArr[i3 + i7]);
        }
        BigInteger bigInteger = new BigInteger(sb.toString());
        while (true) {
            iArr2[i6] = bigInteger.mod(BigInteger.valueOf(900L)).intValue();
            bigInteger = bigInteger.divide(BigInteger.valueOf(900L));
            int i8 = i6 + 1;
            if (bigInteger.compareTo(BigInteger.ZERO) != 1) {
                break;
            } else {
                i6 = i8;
            }
        }
        while (i6 >= 0) {
            int[] iArr4 = this.f346z;
            int i9 = this.f338A;
            this.f338A = i9 + 1;
            iArr4[i9] = iArr2[i6];
            i6--;
        }
    }

    private void T() {
        int i3;
        int[] iArr = new int[520];
        int[] iArr2 = new int[35];
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        List listN = N(this.f415n);
        int i4 = 0;
        this.f338A = 0;
        int i5 = 1;
        if (this.f404c) {
            this.f346z[0] = 921;
            this.f338A = 1;
        }
        int i6 = this.f414m;
        if (i6 != 3) {
            if (i6 <= 899) {
                int[] iArr3 = this.f346z;
                int i7 = this.f338A;
                iArr3[i7] = 927;
                int i8 = i7 + 1;
                this.f338A = i8;
                iArr3[i8] = i6;
                this.f338A = i7 + 2;
            }
            if (i6 >= 900 && i6 <= 810899) {
                int[] iArr4 = this.f346z;
                int i9 = this.f338A;
                iArr4[i9] = 926;
                int i10 = i9 + 1;
                this.f338A = i10;
                iArr4[i10] = (i6 / 900) - 1;
                int i11 = i9 + 2;
                this.f338A = i11;
                iArr4[i11] = i6 % 900;
                this.f338A = i9 + 3;
            }
            if (i6 >= 810900 && i6 <= 811799) {
                int[] iArr5 = this.f346z;
                int i12 = this.f338A;
                iArr5[i12] = 925;
                int i13 = i12 + 1;
                this.f338A = i13;
                iArr5[i13] = i6 - 810900;
                this.f338A = i12 + 2;
            }
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < listN.size()) {
            a aVar = (a) listN.get(i14);
            int iOrdinal = aVar.f347a.ordinal();
            if (iOrdinal == 1) {
                U(i15, aVar.f348b, i14 == 0);
            } else if (iOrdinal == 2) {
                Q(i15, aVar.f348b, i14 == 0 ? b.TEX : ((a) listN.get(i14 - 1)).f347a);
            } else {
                if (iOrdinal != 3) {
                    throw new H("Unknown block type: " + aVar.f347a);
                }
                S(this.f415n, i15, aVar.f348b, false);
            }
            i15 += aVar.f348b;
            i14++;
        }
        L();
        u("Codewords: ");
        for (int i16 = 0; i16 < this.f338A; i16++) {
            y(this.f346z[i16]);
        }
        v();
        int i17 = this.f342E;
        if (i17 < 0) {
            int i18 = this.f338A;
            if (i18 <= 40) {
                i17 = 2;
            } else if (i18 <= 160) {
                i17 = 3;
            } else if (i18 <= 320) {
                i17 = 4;
            } else {
                i17 = i18 <= 863 ? 5 : 6;
            }
        }
        int i19 = 1 << (i17 + 1);
        int i20 = this.f338A + i19;
        int i21 = i20 + 1;
        Y(3, 90);
        X(1, 30);
        Integer num = this.f340C;
        if (num == null) {
            Integer num2 = this.f341D;
            if (num2 != null) {
                double d3 = i21;
                double dIntValue = num2.intValue();
                Double.isNaN(d3);
                Double.isNaN(dIntValue);
                this.f340C = Integer.valueOf((int) Math.ceil(d3 / dIntValue));
            } else {
                double d4 = i20;
                Double.isNaN(d4);
                Integer numValueOf = Integer.valueOf((int) (Math.sqrt(d4 / 3.0d) + 0.5d));
                this.f340C = numValueOf;
                double d5 = i21;
                double dIntValue2 = numValueOf.intValue();
                Double.isNaN(d5);
                Double.isNaN(dIntValue2);
                this.f341D = Integer.valueOf((int) Math.ceil(d5 / dIntValue2));
            }
        } else if (this.f341D == null) {
            double d6 = i21;
            double dIntValue3 = num.intValue();
            Double.isNaN(d6);
            Double.isNaN(dIntValue3);
            this.f341D = Integer.valueOf((int) Math.ceil(d6 / dIntValue3));
        } else if (num.intValue() * this.f341D.intValue() < i21) {
            throw new H("Too few rows (" + this.f341D + ") and columns (" + this.f340C + ") to hold codewords (" + i21 + ")");
        }
        Y(3, 90);
        X(1, 30);
        for (int iIntValue = (((this.f340C.intValue() * this.f341D.intValue()) - this.f338A) - i19) - 1; iIntValue > 0; iIntValue--) {
            int[] iArr6 = this.f346z;
            int i22 = this.f338A;
            iArr6[i22] = 900;
            this.f338A = i22 + 1;
        }
        int i23 = this.f338A;
        if (i23 >= 0) {
            int[] iArr7 = this.f346z;
            System.arraycopy(iArr7, 0, iArr7, 1, i23);
        }
        int i24 = this.f338A + 1;
        this.f338A = i24;
        this.f346z[0] = i24;
        switch (i17) {
            case 1:
                i3 = 2;
                break;
            case 2:
                i3 = 6;
                break;
            case 3:
                i3 = 14;
                break;
            case 4:
                i3 = 30;
                break;
            case 5:
                i3 = 62;
                break;
            case 6:
                i3 = 126;
                break;
            case 7:
                i3 = 254;
                break;
            case 8:
                i3 = 510;
                break;
            default:
                i3 = 0;
                break;
        }
        for (int i25 = 0; i25 < 520; i25++) {
            iArr[i25] = 0;
        }
        for (int i26 = 0; i26 < this.f338A; i26++) {
            int i27 = i19 - 1;
            int i28 = (this.f346z[i26] + iArr[i27]) % 929;
            while (i27 > 0) {
                iArr[i27] = ((iArr[i27 - 1] + 929) - ((i28 * f326I[i3 + i27]) % 929)) % 929;
                i27--;
            }
            iArr[0] = (929 - ((i28 * f326I[i27 + i3]) % 929)) % 929;
        }
        w("Data Codewords: " + this.f338A);
        w("ECC Codewords: " + i19);
        for (int i29 = i19 - 1; i29 >= 0; i29--) {
            int[] iArr8 = this.f346z;
            int i30 = this.f338A;
            this.f338A = i30 + 1;
            int i31 = iArr[i29];
            iArr8[i30] = i31 != 0 ? 929 - i31 : 0;
        }
        if (this.f338A > 929) {
            throw new H("Too many codewords required (" + this.f338A + ", but max is 929)");
        }
        int iIntValue2 = (this.f341D.intValue() - 1) / 3;
        int iIntValue3 = (i17 * 3) + ((this.f341D.intValue() - 1) % 3);
        int iIntValue4 = this.f340C.intValue() - 1;
        this.f416o = "";
        this.f418q = this.f341D.intValue();
        this.f417p = new String[this.f341D.intValue()];
        this.f419r = new int[this.f341D.intValue()];
        w("Grid Size: " + this.f340C + " X " + this.f341D);
        int i32 = 0;
        while (i32 < this.f341D.intValue()) {
            int i33 = 0;
            while (i33 < this.f340C.intValue()) {
                int i34 = i33 + 1;
                iArr2[i34] = this.f346z[(this.f340C.intValue() * i32) + i33];
                i33 = i34;
            }
            int i35 = (i32 / 3) * 30;
            int i36 = i32 % 3;
            if (i36 == 0) {
                iArr2[i4] = i35 + iIntValue2;
                iArr2[this.f340C.intValue() + i5] = i35 + iIntValue4;
                i3 = 0;
            } else if (i36 == i5) {
                iArr2[i4] = i35 + iIntValue3;
                iArr2[this.f340C.intValue() + i5] = i35 + iIntValue2;
                i3 = 929;
            } else if (i36 == 2) {
                iArr2[i4] = i35 + iIntValue4;
                iArr2[this.f340C.intValue() + i5] = i35 + iIntValue3;
                i3 = 1858;
            }
            sb.setLength(i4);
            sb.append("+*");
            int i37 = 0;
            while (i37 <= this.f340C.intValue() + i5) {
                if (this.f339B != c.TRUNCATED || i37 <= this.f340C.intValue()) {
                    sb.append(f327J[iArr2[i37] + i3]);
                    sb.append('*');
                }
                i37++;
                i5 = 1;
            }
            if (this.f339B != c.TRUNCATED) {
                sb.append('-');
            }
            sb2.setLength(i4);
            for (int i38 = 0; i38 < sb.length(); i38++) {
                sb2.append(f329L[G2.a.c(sb.charAt(i38), f328K)]);
            }
            this.f417p[i32] = Q.a(sb2);
            this.f419r[i32] = this.f405d;
            i32++;
            i4 = 0;
            i5 = 1;
        }
    }

    private void U(int i3, int i4, boolean z3) {
        int i5;
        int[] iArr = new int[i4];
        int[] iArr2 = new int[i4];
        int[] iArr3 = new int[i4 * 4];
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = this.f415n[i3 + i6];
            if (i7 == 9) {
                iArr[i6] = 12;
                iArr2[i6] = 12;
            } else if (i7 == 10) {
                iArr[i6] = 8;
                iArr2[i6] = 15;
            } else if (i7 != 13) {
                int i8 = i7 - 32;
                iArr[i6] = f330M[i8];
                iArr2[i6] = f331N[i8];
            } else {
                iArr[i6] = 12;
                iArr2[i6] = 11;
            }
        }
        int i9 = 0;
        int i10 = 0;
        int i11 = 1;
        while (i9 < i4) {
            int i12 = iArr[i9];
            if ((i12 & i11) != 0) {
                iArr3[i10] = iArr2[i9];
                i10++;
            } else {
                int i13 = i4 - 1;
                boolean z4 = i9 == i13 || (iArr[i9 + 1] & i12) == 0;
                if (z4) {
                    if ((i12 & 1) != 0 && i11 == 2) {
                        iArr3[i10] = 27;
                        iArr3[i10 + 1] = iArr2[i9];
                        i10 += 2;
                    }
                    if ((iArr[i9] & 8) != 0) {
                        iArr3[i10] = 29;
                        iArr3[i10 + 1] = iArr2[i9];
                        i10 += 2;
                    }
                    int i14 = iArr[i9];
                    if (((i14 & 1) == 0 || i11 != 2) && (i14 & 8) == 0) {
                        z4 = false;
                    }
                }
                if (!z4) {
                    if (i9 == i13) {
                        i5 = iArr[i9];
                    } else {
                        i5 = iArr[i9];
                        int i15 = iArr[i9 + 1];
                        if ((i5 & i15) != 0) {
                            i5 &= i15;
                        }
                    }
                    switch (i5) {
                        case 3:
                        case 5:
                        case 7:
                        case 9:
                        case 11:
                        case 13:
                        case 15:
                            i5 = 1;
                            break;
                        case 6:
                        case 10:
                        case 14:
                            i5 = 2;
                            break;
                        case 12:
                            i5 = 4;
                            break;
                    }
                    if (i11 == 1) {
                        if (i5 == 2) {
                            iArr3[i10] = 27;
                        } else if (i5 == 4) {
                            iArr3[i10] = 28;
                        } else if (i5 == 8) {
                            iArr3[i10] = 28;
                            iArr3[i10 + 1] = 25;
                            i10 += 2;
                        }
                        i10++;
                    } else if (i11 == 2) {
                        if (i5 == 1) {
                            iArr3[i10] = 28;
                            iArr3[i10 + 1] = 28;
                        } else if (i5 == 4) {
                            iArr3[i10] = 28;
                            i10++;
                        } else if (i5 == 8) {
                            iArr3[i10] = 28;
                            iArr3[i10 + 1] = 25;
                        }
                        i10 += 2;
                    } else if (i11 == 4) {
                        if (i5 == 1) {
                            iArr3[i10] = 28;
                        } else if (i5 == 2) {
                            iArr3[i10] = 27;
                        } else if (i5 == 8) {
                            iArr3[i10] = 25;
                        }
                        i10++;
                    } else if (i11 == 8) {
                        if (i5 != 1) {
                            if (i5 == 2) {
                                iArr3[i10] = 29;
                                iArr3[i10 + 1] = 27;
                            } else if (i5 == 4) {
                                iArr3[i10] = 29;
                                iArr3[i10 + 1] = 28;
                            }
                            i10 += 2;
                        } else {
                            iArr3[i10] = 29;
                            i10++;
                        }
                    }
                    iArr3[i10] = iArr2[i9];
                    i10++;
                    i11 = i5;
                }
            }
            i9++;
        }
        if ((i10 & 1) != 0) {
            iArr3[i10] = 29;
            i10++;
        }
        if (!z3) {
            int[] iArr4 = this.f346z;
            int i16 = this.f338A;
            iArr4[i16] = 900;
            this.f338A = i16 + 1;
        }
        for (int i17 = 0; i17 < i10; i17 += 2) {
            int i18 = (iArr3[i17] * 30) + iArr3[i17 + 1];
            int[] iArr5 = this.f346z;
            int i19 = this.f338A;
            iArr5[i19] = i18;
            this.f338A = i19 + 1;
        }
    }

    private static void W(List list) {
        b bVar;
        int i3 = 0;
        int i4 = 0;
        while (i4 < list.size()) {
            a aVar = (a) list.get(i4);
            b bVar2 = i4 > 0 ? ((a) list.get(i4 - 1)).f347a : b.FALSE;
            b bVar3 = i4 < list.size() - 1 ? ((a) list.get(i4 + 1)).f347a : b.FALSE;
            b bVar4 = aVar.f347a;
            b bVar5 = b.NUM;
            if (bVar4 == bVar5) {
                if (i4 == 0) {
                    b bVar6 = b.TEX;
                    if (bVar3 != bVar6 || aVar.f348b >= 8) {
                        b bVar7 = b.BYT;
                        if (bVar3 == bVar7 && aVar.f348b == 1) {
                            aVar.f347a = bVar7;
                        }
                    } else {
                        aVar.f347a = bVar6;
                    }
                } else if (i4 == list.size() - 1) {
                    b bVar8 = b.TEX;
                    if (bVar2 != bVar8 || aVar.f348b >= 7) {
                        b bVar9 = b.BYT;
                        if (bVar2 == bVar9 && aVar.f348b == 1) {
                            aVar.f347a = bVar9;
                        }
                    } else {
                        aVar.f347a = bVar8;
                    }
                } else {
                    b bVar10 = b.BYT;
                    if (bVar2 == bVar10 && bVar3 == bVar10 && aVar.f348b < 4) {
                        aVar.f347a = bVar10;
                    } else if (bVar2 == bVar10 && bVar3 == (bVar = b.TEX) && aVar.f348b < 4) {
                        aVar.f347a = bVar;
                    } else {
                        b bVar11 = b.TEX;
                        if (bVar2 == bVar11 && bVar3 == bVar10 && aVar.f348b < 5) {
                            aVar.f347a = bVar11;
                        } else if (bVar2 == bVar11 && bVar3 == bVar11 && aVar.f348b < 8) {
                            aVar.f347a = bVar11;
                        } else if (bVar2 == bVar5 && bVar3 == bVar11 && aVar.f348b < 8) {
                            aVar.f347a = bVar11;
                        }
                    }
                }
            }
            i4++;
        }
        P(list);
        while (i3 < list.size()) {
            a aVar2 = (a) list.get(i3);
            b bVar12 = i3 > 0 ? ((a) list.get(i3 - 1)).f347a : b.FALSE;
            b bVar13 = i3 < list.size() - 1 ? ((a) list.get(i3 + 1)).f347a : b.FALSE;
            if (aVar2.f347a == b.TEX && i3 > 0) {
                if (i3 == list.size() - 1) {
                    b bVar14 = b.BYT;
                    if (bVar12 == bVar14 && aVar2.f348b == 1) {
                        aVar2.f347a = bVar14;
                    }
                } else {
                    b bVar15 = b.BYT;
                    if (bVar12 == bVar15 && bVar13 == bVar15 && aVar2.f348b < 5) {
                        aVar2.f347a = bVar15;
                    }
                    if (((bVar12 == bVar15 && bVar13 != bVar15) || (bVar12 != bVar15 && bVar13 == bVar15)) && aVar2.f348b < 3) {
                        aVar2.f347a = bVar15;
                    }
                }
            }
            i3++;
        }
        P(list);
    }

    private void X(int i3, int i4) {
        Integer num = this.f340C;
        if (num != null) {
            if (num.intValue() < i3) {
                throw new H("Too few columns (" + this.f340C + ")");
            }
            if (this.f340C.intValue() <= i4) {
                return;
            }
            throw new H("Too many columns (" + this.f340C + ")");
        }
    }

    private void Y(int i3, int i4) {
        Integer num = this.f341D;
        if (num != null) {
            if (num.intValue() < i3) {
                throw new H("Too few rows (" + this.f341D + ")");
            }
            if (this.f341D.intValue() <= i4) {
                return;
            }
            throw new H("Too many rows (" + this.f341D + ")");
        }
    }

    @Override // E2.Q
    public void B(int i3) {
        super.B(i3);
    }

    public void V(c cVar) {
        this.f339B = cVar;
    }

    @Override // E2.Q
    protected void c() {
        b();
        if (this.f339B.ordinal() != 2) {
            T();
        } else {
            R();
        }
    }
}
