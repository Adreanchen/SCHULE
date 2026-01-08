<?php

use yii\helpers\Html;

/** @var yii\web\View $this */
/** @var app\models\Produkte $model */

$this->title = Yii::t('app', 'Update Produkte: {name}', [
    'name' => $model->ProduktID,
]);
$this->params['breadcrumbs'][] = ['label' => Yii::t('app', 'Produktes'), 'url' => ['index']];
$this->params['breadcrumbs'][] = ['label' => $model->ProduktID, 'url' => ['view', 'ProduktID' => $model->ProduktID]];
$this->params['breadcrumbs'][] = Yii::t('app', 'Update');
?>
<div class="produkte-update">

    <h1><?= Html::encode($this->title) ?></h1>

    <?= $this->render('_form', [
        'model' => $model,
    ]) ?>

</div>
