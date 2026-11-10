package G2;

import E2.H;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f1070a;

    static {
        HashMap map = new HashMap();
        f1070a = map;
        map.put(0, new byte[]{1, 18, 18});
        map.put(1, new byte[]{1, 14, 14});
        map.put(2, new byte[]{1, 14, 14});
        map.put(10, new byte[]{2, 0, 20});
        map.put(11, new byte[]{1, 6, 6});
        map.put(12, new byte[]{1, 6, 6});
        map.put(13, new byte[]{1, 6, 6});
        map.put(15, new byte[]{1, 6, 6});
        map.put(16, new byte[]{1, 6, 6});
        map.put(17, new byte[]{1, 6, 6});
        map.put(20, new byte[]{1, 2, 2});
        map.put(21, new byte[]{2, 0, 20});
        map.put(22, new byte[]{2, 0, 20});
        map.put(235, new byte[]{2, 0, 28});
        map.put(240, new byte[]{2, 0, 30});
        map.put(241, new byte[]{2, 0, 30});
        map.put(242, new byte[]{1, 0, 6});
        map.put(243, new byte[]{2, 0, 20});
        map.put(250, new byte[]{2, 0, 30});
        map.put(251, new byte[]{2, 0, 30});
        map.put(253, new byte[]{1, 13, 13, 2, 0, 17});
        map.put(254, new byte[]{2, 0, 20});
        map.put(255, new byte[]{1, 13, 13, 1, 0, 12});
        map.put(30, new byte[]{1, 0, 8});
        map.put(3100, new byte[]{1, 6, 6});
        map.put(3101, new byte[]{1, 6, 6});
        map.put(3102, new byte[]{1, 6, 6});
        map.put(3103, new byte[]{1, 6, 6});
        map.put(3104, new byte[]{1, 6, 6});
        map.put(3105, new byte[]{1, 6, 6});
        map.put(3110, new byte[]{1, 6, 6});
        map.put(3111, new byte[]{1, 6, 6});
        map.put(3112, new byte[]{1, 6, 6});
        map.put(3113, new byte[]{1, 6, 6});
        map.put(3114, new byte[]{1, 6, 6});
        map.put(3115, new byte[]{1, 6, 6});
        map.put(3120, new byte[]{1, 6, 6});
        map.put(3121, new byte[]{1, 6, 6});
        map.put(3122, new byte[]{1, 6, 6});
        map.put(3123, new byte[]{1, 6, 6});
        map.put(3124, new byte[]{1, 6, 6});
        map.put(3125, new byte[]{1, 6, 6});
        map.put(3130, new byte[]{1, 6, 6});
        map.put(3131, new byte[]{1, 6, 6});
        map.put(3132, new byte[]{1, 6, 6});
        map.put(3133, new byte[]{1, 6, 6});
        map.put(3134, new byte[]{1, 6, 6});
        map.put(3135, new byte[]{1, 6, 6});
        map.put(3140, new byte[]{1, 6, 6});
        map.put(3141, new byte[]{1, 6, 6});
        map.put(3142, new byte[]{1, 6, 6});
        map.put(3143, new byte[]{1, 6, 6});
        map.put(3144, new byte[]{1, 6, 6});
        map.put(3145, new byte[]{1, 6, 6});
        map.put(3150, new byte[]{1, 6, 6});
        map.put(3151, new byte[]{1, 6, 6});
        map.put(3152, new byte[]{1, 6, 6});
        map.put(3153, new byte[]{1, 6, 6});
        map.put(3154, new byte[]{1, 6, 6});
        map.put(3155, new byte[]{1, 6, 6});
        map.put(3160, new byte[]{1, 6, 6});
        map.put(3161, new byte[]{1, 6, 6});
        map.put(3162, new byte[]{1, 6, 6});
        map.put(3163, new byte[]{1, 6, 6});
        map.put(3164, new byte[]{1, 6, 6});
        map.put(3165, new byte[]{1, 6, 6});
        map.put(3200, new byte[]{1, 6, 6});
        map.put(3201, new byte[]{1, 6, 6});
        map.put(3202, new byte[]{1, 6, 6});
        map.put(3203, new byte[]{1, 6, 6});
        map.put(3204, new byte[]{1, 6, 6});
        map.put(3205, new byte[]{1, 6, 6});
        map.put(3210, new byte[]{1, 6, 6});
        map.put(3211, new byte[]{1, 6, 6});
        map.put(3212, new byte[]{1, 6, 6});
        map.put(3213, new byte[]{1, 6, 6});
        map.put(3214, new byte[]{1, 6, 6});
        map.put(3215, new byte[]{1, 6, 6});
        map.put(3220, new byte[]{1, 6, 6});
        map.put(3221, new byte[]{1, 6, 6});
        map.put(3222, new byte[]{1, 6, 6});
        map.put(3223, new byte[]{1, 6, 6});
        map.put(3224, new byte[]{1, 6, 6});
        map.put(3225, new byte[]{1, 6, 6});
        map.put(3230, new byte[]{1, 6, 6});
        map.put(3231, new byte[]{1, 6, 6});
        map.put(3232, new byte[]{1, 6, 6});
        map.put(3233, new byte[]{1, 6, 6});
        map.put(3234, new byte[]{1, 6, 6});
        map.put(3235, new byte[]{1, 6, 6});
        map.put(3240, new byte[]{1, 6, 6});
        map.put(3241, new byte[]{1, 6, 6});
        map.put(3242, new byte[]{1, 6, 6});
        map.put(3243, new byte[]{1, 6, 6});
        map.put(3244, new byte[]{1, 6, 6});
        map.put(3245, new byte[]{1, 6, 6});
        map.put(3250, new byte[]{1, 6, 6});
        map.put(3251, new byte[]{1, 6, 6});
        map.put(3252, new byte[]{1, 6, 6});
        map.put(3253, new byte[]{1, 6, 6});
        map.put(3254, new byte[]{1, 6, 6});
        map.put(3255, new byte[]{1, 6, 6});
        map.put(3260, new byte[]{1, 6, 6});
        map.put(3261, new byte[]{1, 6, 6});
        map.put(3262, new byte[]{1, 6, 6});
        map.put(3263, new byte[]{1, 6, 6});
        map.put(3264, new byte[]{1, 6, 6});
        map.put(3265, new byte[]{1, 6, 6});
        map.put(3270, new byte[]{1, 6, 6});
        map.put(3271, new byte[]{1, 6, 6});
        map.put(3272, new byte[]{1, 6, 6});
        map.put(3273, new byte[]{1, 6, 6});
        map.put(3274, new byte[]{1, 6, 6});
        map.put(3275, new byte[]{1, 6, 6});
        map.put(3280, new byte[]{1, 6, 6});
        map.put(3281, new byte[]{1, 6, 6});
        map.put(3282, new byte[]{1, 6, 6});
        map.put(3283, new byte[]{1, 6, 6});
        map.put(3284, new byte[]{1, 6, 6});
        map.put(3285, new byte[]{1, 6, 6});
        map.put(3290, new byte[]{1, 6, 6});
        map.put(3291, new byte[]{1, 6, 6});
        map.put(3292, new byte[]{1, 6, 6});
        map.put(3293, new byte[]{1, 6, 6});
        map.put(3294, new byte[]{1, 6, 6});
        map.put(3295, new byte[]{1, 6, 6});
        map.put(3300, new byte[]{1, 6, 6});
        map.put(3301, new byte[]{1, 6, 6});
        map.put(3302, new byte[]{1, 6, 6});
        map.put(3303, new byte[]{1, 6, 6});
        map.put(3304, new byte[]{1, 6, 6});
        map.put(3305, new byte[]{1, 6, 6});
        map.put(3310, new byte[]{1, 6, 6});
        map.put(3311, new byte[]{1, 6, 6});
        map.put(3312, new byte[]{1, 6, 6});
        map.put(3313, new byte[]{1, 6, 6});
        map.put(3314, new byte[]{1, 6, 6});
        map.put(3315, new byte[]{1, 6, 6});
        map.put(3320, new byte[]{1, 6, 6});
        map.put(3321, new byte[]{1, 6, 6});
        map.put(3322, new byte[]{1, 6, 6});
        map.put(3323, new byte[]{1, 6, 6});
        map.put(3324, new byte[]{1, 6, 6});
        map.put(3325, new byte[]{1, 6, 6});
        map.put(3330, new byte[]{1, 6, 6});
        map.put(3331, new byte[]{1, 6, 6});
        map.put(3332, new byte[]{1, 6, 6});
        map.put(3333, new byte[]{1, 6, 6});
        map.put(3334, new byte[]{1, 6, 6});
        map.put(3335, new byte[]{1, 6, 6});
        map.put(3340, new byte[]{1, 6, 6});
        map.put(3341, new byte[]{1, 6, 6});
        map.put(3342, new byte[]{1, 6, 6});
        map.put(3343, new byte[]{1, 6, 6});
        map.put(3344, new byte[]{1, 6, 6});
        map.put(3345, new byte[]{1, 6, 6});
        map.put(3350, new byte[]{1, 6, 6});
        map.put(3351, new byte[]{1, 6, 6});
        map.put(3352, new byte[]{1, 6, 6});
        map.put(3353, new byte[]{1, 6, 6});
        map.put(3354, new byte[]{1, 6, 6});
        map.put(3355, new byte[]{1, 6, 6});
        map.put(3360, new byte[]{1, 6, 6});
        map.put(3361, new byte[]{1, 6, 6});
        map.put(3362, new byte[]{1, 6, 6});
        map.put(3363, new byte[]{1, 6, 6});
        map.put(3364, new byte[]{1, 6, 6});
        map.put(3365, new byte[]{1, 6, 6});
        map.put(3370, new byte[]{1, 6, 6});
        map.put(3371, new byte[]{1, 6, 6});
        map.put(3372, new byte[]{1, 6, 6});
        map.put(3373, new byte[]{1, 6, 6});
        map.put(3374, new byte[]{1, 6, 6});
        map.put(3375, new byte[]{1, 6, 6});
        map.put(3400, new byte[]{1, 6, 6});
        map.put(3401, new byte[]{1, 6, 6});
        map.put(3402, new byte[]{1, 6, 6});
        map.put(3403, new byte[]{1, 6, 6});
        map.put(3404, new byte[]{1, 6, 6});
        map.put(3405, new byte[]{1, 6, 6});
        map.put(3410, new byte[]{1, 6, 6});
        map.put(3411, new byte[]{1, 6, 6});
        map.put(3412, new byte[]{1, 6, 6});
        map.put(3413, new byte[]{1, 6, 6});
        map.put(3414, new byte[]{1, 6, 6});
        map.put(3415, new byte[]{1, 6, 6});
        map.put(3420, new byte[]{1, 6, 6});
        map.put(3421, new byte[]{1, 6, 6});
        map.put(3422, new byte[]{1, 6, 6});
        map.put(3423, new byte[]{1, 6, 6});
        map.put(3424, new byte[]{1, 6, 6});
        map.put(3425, new byte[]{1, 6, 6});
        map.put(3430, new byte[]{1, 6, 6});
        map.put(3431, new byte[]{1, 6, 6});
        map.put(3432, new byte[]{1, 6, 6});
        map.put(3433, new byte[]{1, 6, 6});
        map.put(3434, new byte[]{1, 6, 6});
        map.put(3435, new byte[]{1, 6, 6});
        map.put(3440, new byte[]{1, 6, 6});
        map.put(3441, new byte[]{1, 6, 6});
        map.put(3442, new byte[]{1, 6, 6});
        map.put(3443, new byte[]{1, 6, 6});
        map.put(3444, new byte[]{1, 6, 6});
        map.put(3445, new byte[]{1, 6, 6});
        map.put(3450, new byte[]{1, 6, 6});
        map.put(3451, new byte[]{1, 6, 6});
        map.put(3452, new byte[]{1, 6, 6});
        map.put(3453, new byte[]{1, 6, 6});
        map.put(3454, new byte[]{1, 6, 6});
        map.put(3455, new byte[]{1, 6, 6});
        map.put(3460, new byte[]{1, 6, 6});
        map.put(3461, new byte[]{1, 6, 6});
        map.put(3462, new byte[]{1, 6, 6});
        map.put(3463, new byte[]{1, 6, 6});
        map.put(3464, new byte[]{1, 6, 6});
        map.put(3465, new byte[]{1, 6, 6});
        map.put(3470, new byte[]{1, 6, 6});
        map.put(3471, new byte[]{1, 6, 6});
        map.put(3472, new byte[]{1, 6, 6});
        map.put(3473, new byte[]{1, 6, 6});
        map.put(3474, new byte[]{1, 6, 6});
        map.put(3475, new byte[]{1, 6, 6});
        map.put(3480, new byte[]{1, 6, 6});
        map.put(3481, new byte[]{1, 6, 6});
        map.put(3482, new byte[]{1, 6, 6});
        map.put(3483, new byte[]{1, 6, 6});
        map.put(3484, new byte[]{1, 6, 6});
        map.put(3485, new byte[]{1, 6, 6});
        map.put(3490, new byte[]{1, 6, 6});
        map.put(3491, new byte[]{1, 6, 6});
        map.put(3492, new byte[]{1, 6, 6});
        map.put(3493, new byte[]{1, 6, 6});
        map.put(3494, new byte[]{1, 6, 6});
        map.put(3495, new byte[]{1, 6, 6});
        map.put(3500, new byte[]{1, 6, 6});
        map.put(3501, new byte[]{1, 6, 6});
        map.put(3502, new byte[]{1, 6, 6});
        map.put(3503, new byte[]{1, 6, 6});
        map.put(3504, new byte[]{1, 6, 6});
        map.put(3505, new byte[]{1, 6, 6});
        map.put(3510, new byte[]{1, 6, 6});
        map.put(3511, new byte[]{1, 6, 6});
        map.put(3512, new byte[]{1, 6, 6});
        map.put(3513, new byte[]{1, 6, 6});
        map.put(3514, new byte[]{1, 6, 6});
        map.put(3515, new byte[]{1, 6, 6});
        map.put(3520, new byte[]{1, 6, 6});
        map.put(3521, new byte[]{1, 6, 6});
        map.put(3522, new byte[]{1, 6, 6});
        map.put(3523, new byte[]{1, 6, 6});
        map.put(3524, new byte[]{1, 6, 6});
        map.put(3525, new byte[]{1, 6, 6});
        map.put(3530, new byte[]{1, 6, 6});
        map.put(3531, new byte[]{1, 6, 6});
        map.put(3532, new byte[]{1, 6, 6});
        map.put(3533, new byte[]{1, 6, 6});
        map.put(3534, new byte[]{1, 6, 6});
        map.put(3535, new byte[]{1, 6, 6});
        map.put(3540, new byte[]{1, 6, 6});
        map.put(3541, new byte[]{1, 6, 6});
        map.put(3542, new byte[]{1, 6, 6});
        map.put(3543, new byte[]{1, 6, 6});
        map.put(3544, new byte[]{1, 6, 6});
        map.put(3545, new byte[]{1, 6, 6});
        map.put(3550, new byte[]{1, 6, 6});
        map.put(3551, new byte[]{1, 6, 6});
        map.put(3552, new byte[]{1, 6, 6});
        map.put(3553, new byte[]{1, 6, 6});
        map.put(3554, new byte[]{1, 6, 6});
        map.put(3555, new byte[]{1, 6, 6});
        map.put(3560, new byte[]{1, 6, 6});
        map.put(3561, new byte[]{1, 6, 6});
        map.put(3562, new byte[]{1, 6, 6});
        map.put(3563, new byte[]{1, 6, 6});
        map.put(3564, new byte[]{1, 6, 6});
        map.put(3565, new byte[]{1, 6, 6});
        map.put(3570, new byte[]{1, 6, 6});
        map.put(3571, new byte[]{1, 6, 6});
        map.put(3572, new byte[]{1, 6, 6});
        map.put(3573, new byte[]{1, 6, 6});
        map.put(3574, new byte[]{1, 6, 6});
        map.put(3575, new byte[]{1, 6, 6});
        map.put(3600, new byte[]{1, 6, 6});
        map.put(3601, new byte[]{1, 6, 6});
        map.put(3602, new byte[]{1, 6, 6});
        map.put(3603, new byte[]{1, 6, 6});
        map.put(3604, new byte[]{1, 6, 6});
        map.put(3605, new byte[]{1, 6, 6});
        map.put(3610, new byte[]{1, 6, 6});
        map.put(3611, new byte[]{1, 6, 6});
        map.put(3612, new byte[]{1, 6, 6});
        map.put(3613, new byte[]{1, 6, 6});
        map.put(3614, new byte[]{1, 6, 6});
        map.put(3615, new byte[]{1, 6, 6});
        map.put(3620, new byte[]{1, 6, 6});
        map.put(3621, new byte[]{1, 6, 6});
        map.put(3622, new byte[]{1, 6, 6});
        map.put(3623, new byte[]{1, 6, 6});
        map.put(3624, new byte[]{1, 6, 6});
        map.put(3625, new byte[]{1, 6, 6});
        map.put(3630, new byte[]{1, 6, 6});
        map.put(3631, new byte[]{1, 6, 6});
        map.put(3632, new byte[]{1, 6, 6});
        map.put(3633, new byte[]{1, 6, 6});
        map.put(3634, new byte[]{1, 6, 6});
        map.put(3635, new byte[]{1, 6, 6});
        map.put(3640, new byte[]{1, 6, 6});
        map.put(3641, new byte[]{1, 6, 6});
        map.put(3642, new byte[]{1, 6, 6});
        map.put(3643, new byte[]{1, 6, 6});
        map.put(3644, new byte[]{1, 6, 6});
        map.put(3645, new byte[]{1, 6, 6});
        map.put(3650, new byte[]{1, 6, 6});
        map.put(3651, new byte[]{1, 6, 6});
        map.put(3652, new byte[]{1, 6, 6});
        map.put(3653, new byte[]{1, 6, 6});
        map.put(3654, new byte[]{1, 6, 6});
        map.put(3655, new byte[]{1, 6, 6});
        map.put(3660, new byte[]{1, 6, 6});
        map.put(3661, new byte[]{1, 6, 6});
        map.put(3662, new byte[]{1, 6, 6});
        map.put(3663, new byte[]{1, 6, 6});
        map.put(3664, new byte[]{1, 6, 6});
        map.put(3665, new byte[]{1, 6, 6});
        map.put(3670, new byte[]{1, 6, 6});
        map.put(3671, new byte[]{1, 6, 6});
        map.put(3672, new byte[]{1, 6, 6});
        map.put(3673, new byte[]{1, 6, 6});
        map.put(3674, new byte[]{1, 6, 6});
        map.put(3675, new byte[]{1, 6, 6});
        map.put(3680, new byte[]{1, 6, 6});
        map.put(3681, new byte[]{1, 6, 6});
        map.put(3682, new byte[]{1, 6, 6});
        map.put(3683, new byte[]{1, 6, 6});
        map.put(3684, new byte[]{1, 6, 6});
        map.put(3685, new byte[]{1, 6, 6});
        map.put(3690, new byte[]{1, 6, 6});
        map.put(3691, new byte[]{1, 6, 6});
        map.put(3692, new byte[]{1, 6, 6});
        map.put(3693, new byte[]{1, 6, 6});
        map.put(3694, new byte[]{1, 6, 6});
        map.put(3695, new byte[]{1, 6, 6});
        map.put(37, new byte[]{1, 0, 8});
        map.put(3900, new byte[]{1, 0, 15});
        map.put(3901, new byte[]{1, 0, 15});
        map.put(3902, new byte[]{1, 0, 15});
        map.put(3903, new byte[]{1, 0, 15});
        map.put(3904, new byte[]{1, 0, 15});
        map.put(3905, new byte[]{1, 0, 15});
        map.put(3906, new byte[]{1, 0, 15});
        map.put(3907, new byte[]{1, 0, 15});
        map.put(3908, new byte[]{1, 0, 15});
        map.put(3909, new byte[]{1, 0, 15});
        map.put(3910, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3911, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3912, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3913, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3914, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3915, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3916, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3917, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3918, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3919, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3920, new byte[]{1, 0, 15});
        map.put(3921, new byte[]{1, 0, 15});
        map.put(3922, new byte[]{1, 0, 15});
        map.put(3923, new byte[]{1, 0, 15});
        map.put(3924, new byte[]{1, 0, 15});
        map.put(3925, new byte[]{1, 0, 15});
        map.put(3926, new byte[]{1, 0, 15});
        map.put(3927, new byte[]{1, 0, 15});
        map.put(3928, new byte[]{1, 0, 15});
        map.put(3929, new byte[]{1, 0, 15});
        map.put(3930, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3931, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3932, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3933, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3934, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3935, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3936, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3937, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3938, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3939, new byte[]{1, 3, 3, 1, 0, 15});
        map.put(3940, new byte[]{1, 4, 4});
        map.put(3941, new byte[]{1, 4, 4});
        map.put(3942, new byte[]{1, 4, 4});
        map.put(3943, new byte[]{1, 4, 4});
        map.put(3950, new byte[]{1, 6, 6});
        map.put(3951, new byte[]{1, 6, 6});
        map.put(3952, new byte[]{1, 6, 6});
        map.put(3953, new byte[]{1, 6, 6});
        map.put(3954, new byte[]{1, 6, 6});
        map.put(3955, new byte[]{1, 6, 6});
        map.put(3956, new byte[]{1, 6, 6});
        map.put(3957, new byte[]{1, 6, 6});
        map.put(3958, new byte[]{1, 6, 6});
        map.put(3959, new byte[]{1, 6, 6});
        map.put(400, new byte[]{2, 0, 30});
        map.put(401, new byte[]{2, 0, 30});
        map.put(402, new byte[]{1, 17, 17});
        map.put(403, new byte[]{2, 0, 30});
        map.put(410, new byte[]{1, 13, 13});
        map.put(411, new byte[]{1, 13, 13});
        map.put(412, new byte[]{1, 13, 13});
        map.put(413, new byte[]{1, 13, 13});
        map.put(414, new byte[]{1, 13, 13});
        map.put(415, new byte[]{1, 13, 13});
        map.put(416, new byte[]{1, 13, 13});
        map.put(417, new byte[]{1, 13, 13});
        map.put(420, new byte[]{2, 0, 20});
        map.put(421, new byte[]{1, 3, 3, 2, 0, 9});
        map.put(422, new byte[]{1, 3, 3});
        map.put(423, new byte[]{1, 3, 3, 1, 0, 12});
        map.put(424, new byte[]{1, 3, 3});
        map.put(425, new byte[]{1, 3, 3, 1, 0, 12});
        map.put(426, new byte[]{1, 3, 3});
        map.put(427, new byte[]{2, 0, 3});
        map.put(4300, new byte[]{2, 0, 35});
        map.put(4301, new byte[]{2, 0, 35});
        map.put(4302, new byte[]{2, 0, 70});
        map.put(4303, new byte[]{2, 0, 70});
        map.put(4304, new byte[]{2, 0, 70});
        map.put(4305, new byte[]{2, 0, 70});
        map.put(4306, new byte[]{2, 0, 70});
        map.put(4307, new byte[]{4, 2, 2});
        map.put(4308, new byte[]{2, 0, 30});
        map.put(4310, new byte[]{2, 0, 35});
        map.put(4311, new byte[]{2, 0, 35});
        map.put(4312, new byte[]{2, 0, 70});
        map.put(4313, new byte[]{2, 0, 70});
        map.put(4314, new byte[]{2, 0, 70});
        map.put(4315, new byte[]{2, 0, 70});
        map.put(4316, new byte[]{2, 0, 70});
        map.put(4317, new byte[]{4, 2, 2});
        map.put(4318, new byte[]{2, 0, 20});
        map.put(4319, new byte[]{2, 0, 30});
        map.put(4320, new byte[]{2, 0, 35});
        map.put(4321, new byte[]{5, 1, 1});
        map.put(4322, new byte[]{5, 1, 1});
        map.put(4323, new byte[]{5, 1, 1});
        map.put(4324, new byte[]{1, 10, 10});
        map.put(4325, new byte[]{1, 10, 10});
        map.put(4326, new byte[]{1, 6, 6});
        map.put(7001, new byte[]{1, 13, 13});
        map.put(7002, new byte[]{2, 0, 30});
        map.put(7003, new byte[]{1, 10, 10});
        map.put(7004, new byte[]{1, 0, 4});
        map.put(7005, new byte[]{2, 0, 12});
        map.put(7006, new byte[]{1, 6, 6});
        map.put(7007, new byte[]{1, 6, 12});
        map.put(7008, new byte[]{2, 0, 3});
        map.put(7009, new byte[]{2, 0, 10});
        map.put(7010, new byte[]{2, 0, 2});
        map.put(7020, new byte[]{2, 0, 20});
        map.put(7021, new byte[]{2, 0, 20});
        map.put(7022, new byte[]{2, 0, 20});
        map.put(7023, new byte[]{2, 0, 30});
        map.put(7030, new byte[]{1, 3, 3, 2, 0, 27});
        map.put(7031, new byte[]{1, 3, 3, 2, 0, 27});
        map.put(7032, new byte[]{1, 3, 3, 2, 0, 27});
        map.put(7033, new byte[]{1, 3, 3, 2, 0, 27});
        map.put(7034, new byte[]{1, 3, 3, 2, 0, 27});
        map.put(7035, new byte[]{1, 3, 3, 2, 0, 27});
        map.put(7036, new byte[]{1, 3, 3, 2, 0, 27});
        map.put(7037, new byte[]{1, 3, 3, 2, 0, 27});
        map.put(7038, new byte[]{1, 3, 3, 2, 0, 27});
        map.put(7039, new byte[]{1, 3, 3, 2, 0, 27});
        map.put(7040, new byte[]{1, 1, 1, 2, 3, 3});
        map.put(710, new byte[]{2, 0, 20});
        map.put(711, new byte[]{2, 0, 20});
        map.put(712, new byte[]{2, 0, 20});
        map.put(713, new byte[]{2, 0, 20});
        map.put(714, new byte[]{2, 0, 20});
        map.put(715, new byte[]{2, 0, 20});
        map.put(7230, new byte[]{2, 2, 30});
        map.put(7231, new byte[]{2, 2, 30});
        map.put(7232, new byte[]{2, 2, 30});
        map.put(7233, new byte[]{2, 2, 30});
        map.put(7234, new byte[]{2, 2, 30});
        map.put(7235, new byte[]{2, 2, 30});
        map.put(7236, new byte[]{2, 2, 30});
        map.put(7237, new byte[]{2, 2, 30});
        map.put(7238, new byte[]{2, 2, 30});
        map.put(7239, new byte[]{2, 2, 30});
        map.put(7240, new byte[]{2, 0, 20});
        map.put(8001, new byte[]{1, 14, 14});
        map.put(8002, new byte[]{2, 0, 20});
        map.put(8003, new byte[]{1, 14, 14, 2, 0, 16});
        map.put(8004, new byte[]{2, 0, 30});
        map.put(8005, new byte[]{1, 6, 6});
        map.put(8006, new byte[]{1, 18, 18});
        map.put(8007, new byte[]{2, 0, 34});
        map.put(8008, new byte[]{1, 8, 12});
        map.put(8009, new byte[]{2, 0, 50});
        map.put(8010, new byte[]{3, 0, 30});
        map.put(8011, new byte[]{1, 0, 12});
        map.put(8012, new byte[]{2, 0, 20});
        map.put(8013, new byte[]{2, 0, 25});
        map.put(8017, new byte[]{1, 18, 18});
        map.put(8018, new byte[]{1, 18, 18});
        map.put(8019, new byte[]{1, 0, 10});
        map.put(8020, new byte[]{2, 0, 25});
        map.put(8026, new byte[]{1, 18, 18});
        map.put(8110, new byte[]{2, 0, 70});
        map.put(8111, new byte[]{1, 4, 4});
        map.put(8112, new byte[]{2, 0, 70});
        map.put(8200, new byte[]{2, 0, 70});
        map.put(90, new byte[]{2, 0, 30});
        map.put(91, new byte[]{2, 0, 90});
        map.put(92, new byte[]{2, 0, 90});
        map.put(93, new byte[]{2, 0, 90});
        map.put(94, new byte[]{2, 0, 90});
        map.put(95, new byte[]{2, 0, 90});
        map.put(96, new byte[]{2, 0, 90});
        map.put(97, new byte[]{2, 0, 90});
        map.put(98, new byte[]{2, 0, 90});
        map.put(99, new byte[]{2, 0, 90});
    }

    public static String a(String str, String str2) {
        int i3;
        int[] iArr;
        int i4;
        char c3;
        char c4;
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder(charArray.length);
        int[] iArr2 = new int[100];
        int[] iArr3 = new int[100];
        int[] iArr4 = new int[100];
        int[] iArr5 = new int[100];
        if (charArray[0] != '[') {
            throw new H("Data does not start with an AI");
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 5;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        boolean z3 = false;
        for (char c5 : charArray) {
            i9 += i10;
            if (i10 != 1 || c5 == ']' || (c5 >= '0' && c5 <= '9')) {
                c3 = '[';
            } else {
                c3 = '[';
                z3 = true;
            }
            if (c5 == c3) {
                i8++;
                c4 = ']';
                i10 = 1;
            } else {
                c4 = ']';
            }
            if (c5 == c4) {
                i8--;
                if (i9 < i7) {
                    i7 = i9;
                }
                i9 = 0;
                i10 = 0;
            }
            if (i8 > i6) {
                i6 = i8;
            }
            if (i9 > i5) {
                i5 = i9;
            }
        }
        int i11 = i7 - 1;
        if (i8 != 0) {
            throw new H("Malformed AI in input data (brackets don't match)");
        }
        if (i6 > 1) {
            throw new H("Found nested brackets in input data");
        }
        if (i5 > 4) {
            throw new H("Invalid AI in input data (AI too long)");
        }
        if (i11 <= 1) {
            throw new H("Invalid AI in input data (AI too short)");
        }
        if (z3) {
            throw new H("Invalid AI in input data (non-numeric characters in AI)");
        }
        int i12 = 0;
        for (int i13 = 1; i13 < charArray.length; i13++) {
            if (charArray[i13 - 1] == '[') {
                iArr3[i12] = i13;
                iArr2[i12] = 0;
                int i14 = 0;
                while (true) {
                    char c6 = charArray[i13 + i14];
                    if (c6 == ']') {
                        break;
                    }
                    int i15 = iArr2[i12] * 10;
                    iArr2[i12] = i15;
                    iArr2[i12] = i15 + Character.getNumericValue(c6);
                    i14++;
                }
                i12++;
            }
        }
        for (int i16 = 0; i16 < i12; i16++) {
            int i17 = iArr3[i16];
            iArr4[i16] = i17 + 3;
            if (iArr2[i16] >= 100) {
                iArr4[i16] = i17 + 4;
            }
            if (iArr2[i16] >= 1000) {
                i4 = 1;
                iArr4[i16] = iArr4[i16] + 1;
            } else {
                i4 = 1;
            }
            iArr5[i16] = charArray.length - iArr4[i16];
            int length = charArray.length - i4;
            while (true) {
                int i18 = iArr4[i16];
                if (length >= i18) {
                    if (charArray[length] == '[') {
                        iArr5[i16] = length - i18;
                    }
                    length--;
                }
            }
        }
        for (int i19 = 0; i19 < i12; i19++) {
            int i20 = iArr2[i19];
            byte[] bArr = (byte[]) f1070a.get(Integer.valueOf(i20));
            if (bArr == null) {
                throw new H("Invalid AI value " + i20);
            }
            int i21 = 0;
            int i22 = 0;
            while (true) {
                int i23 = i21 + 2;
                if (i23 < bArr.length) {
                    byte b3 = bArr[i21];
                    byte b4 = bArr[i21 + 1];
                    byte b5 = bArr[i23];
                    i21 += 3;
                    if (i21 == bArr.length) {
                        i3 = iArr5[i19] - i22;
                        if (i3 < b4 || i3 > b5) {
                            throw new H("Invalid data length for AI " + i20);
                        }
                    } else {
                        if (i22 + b5 > iArr5[i19]) {
                            throw new H("Invalid data length for AI " + i20);
                        }
                        i3 = b5;
                    }
                    int i24 = 0;
                    while (i24 < i3) {
                        char c7 = charArray[iArr4[i19] + i22 + i24];
                        int[] iArr6 = iArr2;
                        if (b3 != 1 || c7 < '0' || c7 > '9') {
                            iArr = iArr4;
                            if ((b3 != 2 || ((c7 < 'A' || c7 > 'Z') && ((c7 < 'a' || c7 > 'z') && ((c7 < '%' || c7 > '?') && c7 != '_' && c7 != '!' && c7 != '\"')))) && ((b3 != 3 || ((c7 < 'A' || c7 > 'Z') && ((c7 < '0' || c7 > '9') && c7 != '#' && c7 != '-' && c7 != '/'))) && ((b3 != 5 || c7 < '0' || c7 > '1') && (b3 != 4 || c7 < 'A' || c7 > 'Z')))) {
                                throw new H("Invalid data value for AI " + i20);
                            }
                        } else {
                            iArr = iArr4;
                        }
                        i24++;
                        iArr2 = iArr6;
                        iArr4 = iArr;
                    }
                    i22 += b5;
                }
            }
        }
        boolean z4 = true;
        for (int i25 = 0; i25 < charArray.length; i25++) {
            char c8 = charArray[i25];
            if (c8 != '[' && c8 != ']') {
                sb.append(c8);
            }
            if (charArray[i25] == '[') {
                if (!z4) {
                    sb.append(str2);
                }
                int numericValue = (Character.getNumericValue(charArray[i25 + 1]) * 10) + Character.getNumericValue(charArray[i25 + 2]);
                z4 = (numericValue >= 0 && numericValue <= 4) || (numericValue >= 11 && numericValue <= 20) || numericValue == 23 || ((numericValue >= 31 && numericValue <= 36) || numericValue == 41);
            }
        }
        return sb.toString();
    }
}
