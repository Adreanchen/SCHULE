<?php

use yii\helpers\Html;
use yii\bootstrap5\ActiveForm;

/** @var yii\web\View $this */
/** @var app\models\Lieferanten $model */
/** @var yii\widgets\ActiveForm $form */
?>

<div class="lieferanten-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'Lieferantenname')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'Lieferanten_Email')->textInput(['maxlength' => true]) ?>

    <div class="form-group">
        <?= Html::submitButton(Yii::t('app', 'Save'), ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
