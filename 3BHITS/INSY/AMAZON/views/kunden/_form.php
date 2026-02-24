<?php

use yii\helpers\Html;
use yii\bootstrap5\ActiveForm;

/** @var yii\web\View $this */
/** @var app\models\Kunden $model */
/** @var yii\widgets\ActiveForm $form */
?>

<div class="kunden-form">

    <?php $form = ActiveForm::begin(); ?>

    <?= $form->field($model, 'Kundenname')->textInput(['maxlength' => true]) ?>

    <?= $form->field($model, 'Kunden_Email')->textInput(['maxlength' => true]) ?>

    <div class="form-group">
        <?= Html::submitButton(Yii::t('app', 'Save'), ['class' => 'btn btn-success']) ?>
    </div>

    <?php ActiveForm::end(); ?>

</div>
